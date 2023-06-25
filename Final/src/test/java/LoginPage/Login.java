package LoginPage;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import Base.TestBase;

public class Login extends TestBase
{
	
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	// Login with email id and password
	
	@FindBy(xpath="//input[@id='i0116']")
	WebElement email_signIn;
	
	@FindBy(id="i0118")
	WebElement password_btn;
	
	@FindBy(id="idSIButton9")
	WebElement nextB;

	@FindBy(xpath="//*[@id=\"idBtn_Back\"]")
	WebElement no;
	
	public void login() throws IOException, InterruptedException
	{
		//Fteching email id and password from properties file for login process
		
		Properties prop = new Properties();
        FileInputStream file = new FileInputStream("D:\\eclipse_workspace\\Final\\src\\test\\resources\\properties\\config.properties");
        prop.load(file);
        String email=prop.getProperty("emailid");
        String password=prop.getProperty("password");
        
        email_signIn.sendKeys(email);
        nextB.click();
        Thread.sleep(2000);
        
        password_btn.sendKeys(password);
        nextB.click();
        Thread.sleep(5000); 
        no.click();
        
	}
}
