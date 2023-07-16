package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

   private Properties properties = new Properties();

    public Properties readFromPropertiesFile() {

        try {
            FileInputStream fileInputStream = new FileInputStream("./src/test/Resources/Config/Config.properties");
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public void WriteDataToPropertiesFile(String Key, String Value){

        try {
            FileOutputStream fileOutputStream =new FileOutputStream("src/test/Config/Config.properties");
            properties.setProperty(Key,Value);
            properties.store(fileOutputStream,null);
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }


    }
}
