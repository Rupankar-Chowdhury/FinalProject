package oneCognizant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHeader {
	char alphabets[];
	
	public SearchHeader(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[@id='divAppstoreContainer']/div[1]/div/div/div[2]/div")
	List<WebElement> list;
	public void alphabetlist()
	{
		int size=list.size();
		String ms="";
		for(int i=0;i<size;i++)
		{
			ms=list.get(i).getText();
		}
		alphabets=new char[25];
		int c=0;
		for(int i=0;i<25;i++)
		{
			alphabets[i]=ms.charAt(c++);
			if(c==9 || c==23)
			{
				c=c+1;
			}
		}		
	}
	
	public int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	@FindBy(xpath="//*[contains(@class,\"col s6 m3 l2 appStoreAppDiv\")]")
	List<WebElement> app;
	public void apps(WebDriver driver) throws InterruptedException,Exception {
		
		File f = new File("D:\\eclipse_workspace\\Final\\src\\test\\resources\\Excel\\Apps.xlsx");
		FileInputStream input = new FileInputStream(f);
		XSSFWorkbook w = new XSSFWorkbook(input);
		XSSFSheet s = w.getSheet("Sheet1");
		
		
		int no=getRandomNumber(0,24);
		driver.findElement(By.xpath("//*[@id='divAppstoreContainer']/div[1]/div/div/div[2]/div/div["+no+"]")).click();
		Thread.sleep(3000);
		int size=app.size();
		String n="";
		int j=0;
		int k=0;
		System.out.println("\n******************Applications***********************");
		for(int i=0;i<size;i++)
		{
			n=app.get(i).getText();
			System.out.println(n);
			
			XSSFRow row=s.createRow(j++);
			XSSFCell cell=row.createCell(k);
			cell.setCellValue(n);
			
		}
		FileOutputStream out=new FileOutputStream("D:\\eclipse_workspace\\Final\\src\\test\\resources\\Excel\\Apps.xlsx");
		w.write(out);
		w.close();
	}
	
	
}