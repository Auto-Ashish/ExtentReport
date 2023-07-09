package utils.ExtendReports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class extentReports {

    static ExtentReports report;
    static ExtentTest test;

    @BeforeClass
    public static void initiateReport(){
        String path = System.getProperty("user.dir");
        System.out.println(path);
        report = new ExtentReports(System.getProperty("user.dir")+"\\target\\ExtentReports\\ExtentReportHtml.html");
        test = report.startTest("MyFirstReport");

    }

    @Test
    public void sampleTest(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        if(driver.getTitle().equals("Google"))
        {
            test.log(LogStatus.PASS, "Navigated to the specified URL");
            //test.log(LogStatus.ERROR,"There is some error");
        }
        else
        {
            test.log(LogStatus.FAIL, "Test Failed");
        }
    }


    @AfterClass
    public void closeInstance(){

        report.endTest(test);
        report.flush();



    }


}
