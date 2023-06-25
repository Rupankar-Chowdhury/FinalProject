package Test;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import LoginPage.Login;
import BeCognizant.BeCognizantPage;

public class WorldClockFunctions extends TestBase
{
	Login ob;
	BeCognizantPage ob1;
	
	// Initialize objects for the pages
	
	@BeforeClass
	public void setPage()
	{
		ob=new Login(driver);
		ob1=new BeCognizantPage(driver);
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
		logger=report.createTest("World Clock Report","Test Cases");
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

	// Click on my profile button
	
	@Test(priority=2)
	public void profile() throws InterruptedException
	{		
		try {
			ob1.openProfile();
			reportPass("Profile icon clicked");
			Thread.sleep(1000);
		}catch(Exception e){
			reportFail(e.getMessage());}
	}
	
	// Fetch username and emailID and display the same 
	
	@Test(priority=3)
	public void user_details() throws InterruptedException
	{
		try {
			ob1.userDetails();
			reportPass("User Details Fetched");
			Thread.sleep(1000);
		    }catch(Exception e){
			reportFail(e.getMessage());}
	}
	
	// Check if World Clock message is displayed correctly on BeCognizant Web page
	
	@Test(priority=4)
	public void clockMessage() throws InterruptedException
	{
		try {
			ob1.clockMessageCheck(driver);
			reportPass("World Clock message checked");
			Thread.sleep(1000);
		    }catch(Exception e){
			reportFail(e.getMessage());}
	}
		
	// Check if Bangalore time details is being displayed in BeCognizant page
		
	@Test(priority=5)
	public void bangalore_time_date_details() throws InterruptedException
	{
		try {
			ob1.bangaloreTime();
			reportPass("Bangalore Time Date info fetched from beCognizant page and displayed");
			Thread.sleep(1000);
		    }catch(Exception e){
			reportFail(e.getMessage());}
    }

	// Bangalore Time and Date from beCognizant page verified with system data 
	
	@Test(priority=6)
	public void bangalore_date_time_verify() throws InterruptedException
	{
		try {
			ob1.bangaloreDateTimeCheckWithSystem();
			reportPass("Bangalore Time and Date from beCognizant page verified with google data");
			Thread.sleep(1000);
		    }catch(Exception e){
			reportFail(e.getMessage());}
    }
	
	
	
	@Test(priority=7)
	public void london_time_date_display() throws InterruptedException
	{
		try {
			ob1.londonTime();
			reportPass("London time date details fetched and displayed successfully");
			Thread.sleep(1000);
		    }catch(Exception e){
			reportFail(e.getMessage());}
    }

	@Test(priority=8)
	public void london_time_check() throws InterruptedException
	{
		try {
			ob1.london_time_verify();
			reportPass("London time verification done");
			Thread.sleep(1000);
		    }catch(Exception e){
			reportFail(e.getMessage());}
    }

	@Test(priority=9)
	public void London_date_check() throws InterruptedException
	{
		try {
			ob1.london_date_Verify();
			reportPass("London date verification done");
			Thread.sleep(1000);
		    }catch(Exception e){
			reportFail(e.getMessage());}
    }

	@Test(priority=10)
	public void time_diff_Bangalore_London() throws InterruptedException
	{
		try {
			ob1.timeDifferenceBangaloreAndLondon();
			reportPass("Time difference between London and Bangalore verified");
			Thread.sleep(1000);
		    }catch(Exception e){
			reportFail(e.getMessage());}
    }
	
	@Test(priority=11)
	public void NY_time_date_display() throws InterruptedException
	{
		try {
			ob1.NewYorkTimeDetails();
			reportPass("New York time date details fetched and displayed successfully");
		    }catch(Exception e){
			reportFail(e.getMessage());}
    }

	@Test(priority=12)
	public void NY_time_check() throws InterruptedException
	{
		try {
			ob1.NY_time_verify();
			reportPass("New York time verification done");
		    }catch(Exception e){
			reportFail(e.getMessage());}
    }

	@Test(priority=13)
	public void NY_datecheck() throws InterruptedException
	{
		try {
			ob1.newyork_date_Verify();
			reportPass("New York date verification done");
		    }catch(Exception e){
			reportFail(e.getMessage());}
    }

	@Test(priority=14)
	public void time_diff_Bangalore_NY() throws InterruptedException
	{
		try {
			ob1.timeDifferenceBangaloreAndNewYork();
			reportPass("Time difference between New York and Bangalore verified");
		    }catch(Exception e){
			reportFail(e.getMessage());}
    }
}
