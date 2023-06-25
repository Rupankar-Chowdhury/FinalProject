package Base;

import java.time.Duration;
import java.util.*;
import java.io.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import extentReport.ExtentReportManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public WebDriver driver;
	public ExtentReports report=ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	
	@BeforeClass
	public void openBrowser()
	{
		String browser="";
		try {
            Properties prop = new Properties();
            FileInputStream file = new FileInputStream("D:\\eclipse_workspace\\Final\\src\\test\\resources\\properties\\config.properties");
            prop.load(file);
            browser=prop.getProperty("browser");

        } catch (Exception e) {
            e.printStackTrace();
        }
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void reportPass(String report)
	{
		logger.log(Status.PASS, report);
	}
	
	public void reportFail(String report)
	{
		logger.log(Status.FAIL, report);
	}
	
	@AfterTest
	public void reportend() {
		report.flush();

	}
	
	@AfterClass
	public void close()
	{
		driver.quit();
	}
	
}
