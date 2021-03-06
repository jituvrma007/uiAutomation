# UI Automation Tests
This project is for testing UI of an e-commerce web application using Java, Selenium WebDriver. Browser a bit to know more about the application, and yes please do not forget to view TESTCASES.md file (in the same directory) to see the documentation about the tests we are going to perform. "http://automationpractice.com/index.php"


## Dependencies

Here are the dependencies used in the project for development & testing perspective. 
<br/> Note - All are open source project and widely available over the web. Setup the machine with below applications to test the code further.

* [Java 1.8](https://www.java.com/en/) - Coding Language
* [Selenium 3.141.59](https://selenium.dev/documentation/en/) - Front End Automation Test Utility
* [Maven](https://maven.apache.org/) - Dependency Management
* [TestNG](https://testng.org/doc/) - Unit Testing framework for Java 
* [ExtentReports](http://extentreports.com/) - Reporting framework for our tests
* [Log4j](https://logging.apache.org/log4j/2.x/) - Logging framework for our tests
* [Apache POI](https://poi.apache.org/) - Parse the test data .xlsx files,


## Getting Started

The below steps will get you a copy of the project up and running, on your local machine for development and testing purposes. 

```
1) Open your terminal and do a clone of this project.
   git clone https://github.com/jituvrma007/uiAutomation.git
2) Navigate to the respective directory and run below command.
   mvn clean install
3) Above command will build the project along with test cases.
4) If you something like below text on terminal, means project ran successfully locally. 
````
````
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 90.721 s - in TestSuite
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
````

### Test Reports
Here are a below steps to get a human readable html report.

```
1) Navigate to respective directory where the project is stored locally.
2) Navigate to /report directory.
3) Find the logs inside "executionLogs" directory.
4) Find the logs inside "htmlReports" directory.
````

### Solution include

* Logging -> On console screen and under /report/executionLogs/Logs.log directory.
</br></br>
* Taking screenshot on failed tests -> Please find the screen shots of failed test cases here "/report/screenShots". </br>
  Please note that, the screenshot will also be attached to the human report format.
</br></br>
* Generation human readable report -> Extent Test Report is being generated covering the detailed steps, results and time line.
</br></br>

* Generating random values for insignificant test data, for example, for new user.
</br></br>

* WebDriver factory - Implemented to initiate the driver from the available pool and close respectively. 
</br></br>

* Encapsulation layers like test data, logic of tests, actions on web pages and so on using page object pattern, driven by test data.
</br></br>

* Run tests in parallel mode - yes from test suite xml file, am passing "parallel="methods" which will do this. However I have kept the thread count to 1 by default.
It can be easily changed.
</br></br>

* Ability to run tests for different browsers/OS by configuring - Have done that, though right now I have covered just windows and mac OS and Chrome/Firefox browser respectively.
</br></br>

* ability to run tests for different environments(urls) by configuring/by command-line.
</br></br>

* reading test data from file - Fully dynamically test cases designed. Every test data we can update and change. Along with verification point as well.