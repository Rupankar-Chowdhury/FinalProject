package BeCognizant;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BeCognizantPage
{
	
	public BeCognizantPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[contains(@id,'_MainLink_Me')]")
	WebElement profile;
	public void openProfile() throws InterruptedException 
	{
         //		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
         //		wait.until(ExpectedConditions.elementToBeClickable(profile));
		profile.click();
	}
	
	// Locate user-name and password from profile and display the same
	
	@FindBy(id = "mectrl_currentAccount_primary")
    WebElement userName;
    @FindBy(id = "mectrl_currentAccount_secondary")
    WebElement email;
	public void userDetails()
	{
		System.out.println("");
		System.out.println(userName.getText());
		System.out.println(email.getText());
		System.out.println("");

	}
	
	// Scroll to bottom and Find World Clock message text
	
	@FindBy(xpath="//*[@id='spPageCanvasContent']/div/div/div/div/div/div[5]")
	WebElement scrollupto;
	@FindBy(xpath="//*[@id='60655e4a-73c8-49d0-9571-c762791557af']/div/div/div/div[1]/span")
	WebElement message;
	public void clockMessageCheck(WebDriver driver) throws InterruptedException 
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Thread.sleep(5000);
		jse.executeScript("arguments[0].scrollIntoView(true)", scrollupto);
		String ms=message.getText();
		if(ms.equals("World Clock")) {
			System.out.println("World Clock message displayed correctly"+"\n********************************************");
			System.out.println();
		}
	}
	
	//Display Banaglore Time Date info from beCog page
	
	@FindBy(xpath="//*[@id='60655e4a-73c8-49d0-9571-c762791557af']/div/div/div/div[2]/div/div/div/div/div/div[1]/div/div")
	WebElement bangaloretimedetails;
	public void bangaloreTime() {
		String timeInBangalore=bangaloretimedetails.getText();
		System.out.println("**********Bangalore Time Date Info as displayed on BeCognizant page************");
		System.out.println(timeInBangalore);
		System.out.println();

	}
	
	//Check whether displayed Bangalore date time data is correct or not 
	
	@FindBy(xpath="//*[@id='60655e4a-73c8-49d0-9571-c762791557af']/div/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div[2]/div[2]/div[2]")
	WebElement bangaloreDate;
	@FindBy(xpath="//*[@id='60655e4a-73c8-49d0-9571-c762791557af']/div/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div[2]/div[1]")
	WebElement bangaloreTime;
	public void bangaloreDateTimeCheckWithSystem()
	{	
		 // Date check
		 System.out.println("Date Check");

		 String bdate= bangaloreDate.getText().substring(5);
		 
		 SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		 Date date = new Date();
		 String sysDate= dateFormat.format(date);
		 
	     System.out.println("\nSystem date : "+sysDate);
	     System.out.println("Date in Bangalore as per BeCognizant : "+bdate);		 
		 
		 if(sysDate.contains(bdate))
			 System.out.println("\nSystem date matches with BeCognizant website date");
		 else 
			 System.out.println("\nSystem date does not match with BeCognizant website date");
		 
		 // Time check
		 System.out.println("\nTime Check");
		 
	     String bTime=bangaloreTime.getText();
	     
		 LocalTime currentTime = LocalTime.now();
	     String sysTime = DateTimeFormatters.formatTime(currentTime);
	     sysTime=sysTime.replaceAll(" ","");
	     
	     System.out.println("\nSystem Time : "+sysTime);
	     System.out.println("Time in Bangalore as per BeCognizant : "+bTime);
	     
		 if(sysTime.equalsIgnoreCase(bTime))
			 System.out.println("\nSystem time matches with BeCognizant website time"); 
		 else 
			 System.out.println("\nSystem time does not match with BeCognizant website time");
	}
	
	
	//                          -----------------   L O N D O N   -----------------
	
	
	//Display London date time details 
	
	@FindBy(xpath="//*[@id='60655e4a-73c8-49d0-9571-c762791557af']/div/div/div/div[2]/div/div/div/div/div/div[2]/div/div")
	WebElement londontimedetails;
	public void londonTime() throws ParseException
	{	
		System.out.println();
		String LondonTime=londontimedetails.getText();
		System.out.println("**********London Time Date Info as displayed on BeCognizant page************");
		System.out.println(LondonTime);
	}
	
	//Verify London time
	
	@FindBy(xpath="//*[@id='60655e4a-73c8-49d0-9571-c762791557af']/div/div/div/div[2]/div/div/div/div/div/div[2]/div/div/div/div[2]/div[1]")
	WebElement londontime;
	public void london_time_verify()
	{		
		String ld_time_BeCog=londontime.getText();
		
		String ld_time_Google=GoogleSearch.search("time in London");
		ld_time_Google=ld_time_Google.replaceAll("[^\\x00-\\x7F]","");
		
		System.out.println("London time as per BeCognizant : "+ld_time_BeCog);
		System.out.println("London time as per Google : "+ld_time_Google);
		
		if(ld_time_BeCog.equalsIgnoreCase(ld_time_Google))
			System.out.println("\nLondon time checked with Google and is correct");
		else 
			System.out.println("\nLondon time checked with Google and is incorrect");			
	}
	
	//Verify London date
	
	@FindBy(xpath="//*[@id='60655e4a-73c8-49d0-9571-c762791557af']/div/div/div/div[2]/div/div/div/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]")
	WebElement london_date;	
	public void london_date_Verify()
	{
		// Extracting the date fetched from beCog from format "xxx, 6/23/2023" to "6/23/2023"
		
		String dat=london_date.getText();
		dat=dat.substring(5,dat.length());
		//Converting M/dd/yyyy date format to dd/MMMM/yyyy format  ( ex : 6/24/2023 -> 24 June 2023 )
		String date_from_becog= DateTimeFormatters.convertDateFormat(dat);
		
		//Extracting the date fetched from google by removing the day name to match the above format in beCog page
		
		String date_from_google=GoogleSearch.search("date in London");
		int i=date_from_google.indexOf(" ");
		date_from_google=date_from_google.substring(i+1,date_from_google.length());
		
		System.out.println("London date as per BeCognizant : "+date_from_becog);
		System.out.println("London date as per Google : "+date_from_google);
		
		if(date_from_becog.equalsIgnoreCase(date_from_google))
			System.out.println("\nLondon date checked with Google and is correct");
		else 
			System.out.println("\nLondon date checked with Google and is incorrect");
	}	
	
	//Verify time difference between London and Bangalore
	
	@FindBy(xpath="//div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]")
	WebElement ltd;
	public void timeDifferenceBangaloreAndLondon()
	{
		String g=GoogleSearch.search("time difference between India and London");
		g=g.substring(9,31);
		
		//Extract XX Hours and YY minutes part from the string fetched from google
        String[] parts = g.split(" ");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[3]);
        
        // Creating the final string from google in the format 'Xh Ym'
        String gtd = hours + "h " + minutes + "m";	
        System.out.println("Time difference between Bangalore and London according to Google : "+gtd);
		
        // converting "-Xh Ym" format in beCog page to -> "Xh Ym" , basically cutting out the "-" part
		String cog=ltd.getText();
		cog=cog.substring(1,cog.length());
		System.out.println("Time difference between Bangalore and London according to BeCognizant : "+cog);

		if(cog.equalsIgnoreCase(gtd))
			System.out.println("\nTime differnce between London and Bangalore checked with Google and is correct");
		else
			System.out.println("\nTime differnce between London and Bangalore checked with Google and is incorrect");
	}
	
	
	//                          -----------------   N E W - Y O R K   -----------------
	
	
	//Display New York date time details
	
	@FindBy(xpath="//*[@id='60655e4a-73c8-49d0-9571-c762791557af']/div/div/div/div[2]/div/div/div/div/div/div[3]/div/div")
	WebElement nytimedetails;
	public void NewYorkTimeDetails() throws ParseException
	{	
		System.out.println();
		String nyTime=nytimedetails.getText();
		System.out.println("**********New York Time Date Info as displayed on BeCognizant page************");
		System.out.println(nyTime);
	}	
	
	//Verify New York time 

	@FindBy(xpath="//*[@id='60655e4a-73c8-49d0-9571-c762791557af']/div/div/div/div[2]/div/div/div/div/div/div[3]/div/div/div/div[2]/div[1]")
	WebElement newYorktime;
	public void NY_time_verify()
	{		
		String ny_time_BeCog=newYorktime.getText();
		
		String ny_time_Google=GoogleSearch.search("time in New York");
		ny_time_Google=ny_time_Google.replaceAll("[^\\x00-\\x7F]","");
		
		System.out.println("New York time as per BeCognizant : "+ny_time_BeCog);
		System.out.println("New York time as per Google : "+ny_time_Google);
		
		if(ny_time_BeCog.equalsIgnoreCase(ny_time_Google))
			System.out.println("\nNew York time checked with Google and is correct");
		else 
			System.out.println("\nNew York time checked with Google and is incorrect");	
	}
	
	//Verify New York date
	
	@FindBy(xpath="//*[@id='60655e4a-73c8-49d0-9571-c762791557af']/div/div/div/div[2]/div/div/div/div/div/div[3]/div/div/div/div[2]/div[2]/div[2]")
	WebElement ny_date;	
	public void newyork_date_Verify()
	{
		// Extracting the date fetched from beCog from format "xxx, 6/23/2023" to "6/23/2023"
		
		String dat=ny_date.getText();
		dat=dat.substring(5,dat.length());
		//Converting M/dd/yyyy date format to dd/MMMM/yyyy format  ( ex : 6/24/2023 -> 24 June 2023 )
		String date_from_becog= DateTimeFormatters.convertDateFormat(dat);
		
		//Extracting the date fetched from google by removing the day name to match the above format in beCog page
		
		String date_from_google=GoogleSearch.search("date in New York");
		int i=date_from_google.indexOf(" ");
		date_from_google=date_from_google.substring(i+1,date_from_google.length());
		
		System.out.println("New York date as per BeCognizant : "+date_from_becog);
		System.out.println("New York date as per Google : "+date_from_google);
		
		if(date_from_becog.equalsIgnoreCase(date_from_google))
			System.out.println("\nNew York date checked with Google and is correct");
		else 
			System.out.println("\nNew York date checked with Google and is incorrect");			
	}	
	
    //Verify time difference between New York and Bangalore
	
	@FindBy(xpath="//div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]")
	WebElement ntd;
	public void timeDifferenceBangaloreAndNewYork()
	{
		String g=GoogleSearch.search("time difference between India and New York");
		g=g.substring(9,31);
		
		//Extract XX Hours and YY minutes part from the string fetched from google
        String[] parts = g.split(" ");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[3]);
        
        // Creating the final string from google in the format 'Xh Ym'
        String gtd = hours + "h " + minutes + "m";	
        System.out.println("Time difference between Bangalore and New York according to Google : "+gtd);
		
        // converting "-Xh Ym" format in beCog page to -> "Xh Ym" , basically cutting out the "-" part
		String cog=ntd.getText();
		cog=cog.substring(1,cog.length());
		System.out.println("Time difference between Bangalore and New York according to BeCognizant : "+cog);

		if(cog.equalsIgnoreCase(gtd))
			System.out.println("\nTime differnce between New York and Bangalore checked with Google and is correct");
		else
			System.out.println("\nTime differnce between New York and Bangalore checked with Google and is incorrect");			
	}	
	
	
	//         -----------------   N A V I G A T E   TO    "ONE - C"    P O R T A L   -----------------
	
	
	// Click on OneC potal
	@FindBy(xpath="//div[text()='OneCognizant']")
	WebElement oneC;
	public void oneCognizant(WebDriver driver) throws InterruptedException
	{
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", oneC);
		
		driver.navigate().refresh();
		Actions action=new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        action.sendKeys(Keys.SPACE).perform();
		oneC.click();
	}
	
	// END OF WORLD CLOCK DETAILS CHECK SCENARIO
		
} // CLASS END
