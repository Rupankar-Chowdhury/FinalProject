package oneCognizant;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickViewMore {
	public ClickViewMore(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}	
	
	@FindBy(xpath="//*[@id='div_hotappscontainer']/div/div[2]/div/div[3]/div[1]")
	WebElement viewmore;
	
	public void clickViewMore(WebDriver driver) throws InterruptedException
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", viewmore);
		viewmore.click();
		Thread.sleep(5000);	
	}
}