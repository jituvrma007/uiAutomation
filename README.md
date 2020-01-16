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
* [Apache POI](https://poi.apache.org/) - Parse the test data .xlsx files.


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


## Parameterize Run 
 

```
1) Open your terminal and Navigate to the respective directory where project is cloned and run below command.
   mvn clean install -Dbrowser="FIREFOX" -Durl="http://automationpractice.com/index.php";
   
2) Above command will build the project based on Firefox browser with the default url.

3) For Chrome, the same request will be  -
   mvn clean install -Dbrowser="CHROME" -Durl="http://automationpractice.com/index.php";

4) If the values are not specified as command line argument then it will pick up the default "homepage" url and Chrome browser for execution.
```

## A Gentle Note
Sometimes, it happens that the same tests are working in one browser, however not is different browser.
Moreover, in some cases the behavior is sometime it is running fine, but sometime it is getting failed.

Ideally, the developed script is tested well on mac machine Chrome/Firefox browser.  
So, in case it does not works well then request you to first update your local installed browsers and then try to run the script.
Still issues are coming, Please write back to me : jituvrma007@gmail.com

### Test Reports
Here are a below steps to get a human readable html report.


```
1) Navigate to respective directory where the project is stored locally.
2) Navigate to /report directory.
3) Find the logs inside "executionLogs" directory.
4) Find the logs inside "htmlReports" directory.
````

### Solution include

* Logging -> On console screen and under "/report/executionLogs/Logs.log" directory.
</br></br>

* Taking screenshot on failed tests -> Please find the screen shots of failed test cases here "/report/screenShots".
  Please note that, the screenshot will also be attached to the .html report.
</br></br>

* Generation html human readable report -> Yes, html reports are being generated with using utility ExtentReports. It is covering the detailed steps, pass/fail/skipped results and with the respective time line. It is easy to understand and to analyze supports detailed charts as well.
</br></br>

* WebDriver factory -> Implemented to initiate the driver from the available pool and close respectively. 
</br></br>

* Layers like, PageObjects, Test Layer, setup and infra layers are done. Using page object pattern, data driven framework, Factory pattern to initalize the driver. After all it is just a sample project, we can design and extend this framework to scale our smoke/sanity/regression based tests.
</br></br>

* Run tests in parallel mode -> Yes from "WebTest_TestSuite" file, am passing "parallel="methods" which will do this. 
However I have kept the thread count to 1 by default. It can be easily changed inside the .xml file..
</br></br>

* Generating random values for insignificant test data, for example for new user.
</br></br>

* Ability to run tests for different browsers/OS by configuring -> Have done that, though right now I have covered just Windows/Mac OS and Chrome/Firefox browser respectively.
</br></br>

* Ability to run tests for different environments(urls) by configuring/by command-line. Yes, please cross check the build running mechanism.
</br></br>

* reading test data from spreadsheet file - Fully dynamically test cases designed. We can update each and every test data. Along with verification point for respective test cases as well.