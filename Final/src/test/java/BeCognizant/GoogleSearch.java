package BeCognizant;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch
{
	public static String search(String message)
	{		
		WebDriverManager.chromedriver().setup();
		WebDriver drivertemp = new ChromeDriver();
		
		drivertemp.manage().window().maximize();
		drivertemp.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		drivertemp.get("https://google.com");
		drivertemp.findElement(By.name("q")).sendKeys(message);
		
		// Using Actions class to click enter after entering text in search box
		
		Actions action=new Actions(drivertemp);
	    action.sendKeys(Keys.ENTER).perform();	 
	    
	    //Extracting the search result of date display
	    
		String t=drivertemp.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div/div/div/div[1]")).getText();
		drivertemp.close();
		return t;		
	}	
}
