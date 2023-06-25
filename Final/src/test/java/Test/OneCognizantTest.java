package Test;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import BeCognizant.BeCognizantPage;
import oneCognizant.ClickViewMore;
import oneCognizant.SearchHeader;
import oneCognizant.WindowHandle;
import LoginPage.Login;

public class OneCognizantTest extends TestBase{
	Login ob;
	BeCognizantPage ob1;
	WindowHandle ob2;
	ClickViewMore ob3;
	SearchHeader ob4;
	
	// Initialize objects for the pages
	
	@BeforeClass
	public void setPage()
	{
		ob=new Login(driver);
		ob1=new BeCognizantPage(driver);
		ob2=new WindowHandle();
		ob3=new ClickViewMore(driver);
		ob4=new SearchHeader(driver);
	}
	
	//Open BeCognizant Website
	
	@BeforeClass
	public void openWebsite() throws InterruptedException
	{
		String link="";
		try {
            Properties prop = new Properties();
            FileInputStream file = new FileInputStream("D:\\eclipse_workspace\\Final\\src\\test\\resources\\properties\\config.properties");
            prop.load(file);
            link=prop.getProperty("url");
			} 
		catch (Exception e){
            e.printStackTrace();
        }
		
		try {
			driver.get(link);
			reportPass("Link opened");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	@BeforeTest
	public void reportInitialiser()
	{
		logger=report.createTest("One Cognizant Report","Test Cases");
	}
	
	//Login to my account
	
	@Test(priority=1)
	public void Login() throws InterruptedException
	{
		try {
			ob.login();
			reportPass("Login successfull");
			Thread.sleep(1000);
		}catch(Exception e){
			reportFail(e.getMessage());}
	}
	
	//	--------------------------One Cognizant-----------------------------
		
	//Clicking on One Cognizant
	
	@Test(priority=2)
	public void clickOneCognizant() throws InterruptedException{
		try {
			//ob1.openProfile(driver);
			ob1.oneCognizant(driver);
//			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); // Maximum wait time of 10 seconds
//			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			reportPass("One Cognizant opened");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	//Window is being handled
	
	@Test(priority=3)
	public void handleWindow() {
		try {
			String window[]=ob2.manageWindows(driver);
			String parent = window[0];
			String child = window[1];
			driver.navigate().refresh();
			driver.switchTo().window(child);
			reportPass("Window handled");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	//Clicking on view all apps
	
	@Test(priority=4)
	public void clickViewAllApps() throws InterruptedException {
		try {
			ob3.clickViewMore(driver);
			reportPass("View all apps clicked");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	//click on a random alphabet to generate applications list 
	
	@Test(priority=5)
	public void searchHeader() {
		try {
			ob4.alphabetlist();
			reportPass("Header in search handled");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	//to display applications list and store them
	
	@Test(priority=6)
	public void appnames() throws InterruptedException {
		try {
			ob4.apps(driver);
			reportPass("Applications names displayed");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
}