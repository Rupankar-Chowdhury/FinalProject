package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {

	public static ExtentReports report;

	public static ExtentReports getReportInstance()
	{
		if(report == null)
		{
			ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir")+"/src/test/resources/report/Report.html");
			report =new ExtentReports();
			report.attachReporter(htmlReport);	
		}
		return report;
	}
}