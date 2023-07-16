package driverFactory;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public  static final Logger logger= LogManager.getLogger(DriverFactory.class);

    public WebDriver driver;

    public static ThreadLocal<WebDriver> ldriver = new ThreadLocal<>();

    public WebDriver initialize_driver(String browser) {

        System.out.println("browser value is:" + browser);

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ldriver.set(new ChromeDriver());
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            ldriver.set(new FirefoxDriver());

        } else if (browser.equals("safari")) {
            WebDriverManager.safaridriver();
            ldriver.set(new SafariDriver());
        } else {
            System.out.println("Browser not supported:" + browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    //this method gets driver with ThreadLocal
    public static WebDriver getDriver() {
        return ldriver.get();
    }


}

