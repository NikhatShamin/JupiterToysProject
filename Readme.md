**Project : Jupiter Toys**

Prerequisites
•	Programming Language: Java 1.8 or above
•	Build Management: Maven 3.6.1
•	IDE
1.	IntelliJ IDEA (Community) - In the terminal run mvn idea:idea to create project files or just open pom.xml file as a project
2.	Eclipse - In the terminal run mvn eclipse:eclipse to create project files the open the project

Frameworks:
1.	Cucumber (BDD)
2.	Selenium WebDriver, WebdriverManager
3.	TestNG, JUnit (Unit Testing)

Design:
•	BDD - Scenarios, Data Tables, Scenario Outline, Examples
•	Pages - Page Classes, Page Objects, By Class
•	Parallel Execution - maven-surefire-plugin, TestNG and JUnit 
•	Utilities - log4j for logger management

Reports:
1.	Cucumber Report - target/cucumber-html-reports.html (Open In Browser)
2.	Emailable Report- target/surefire/emailable-report.html
3.	SureFire Report- target/SureFire-reports/index.html

Test Execution:
•	In a terminal navigate to project root directory and run mvn test
•	Run Individual feature file –by right clicking on the feature file and selecting Run Feature file Name
•   Run testng.xml file to generate Cucumber reports

