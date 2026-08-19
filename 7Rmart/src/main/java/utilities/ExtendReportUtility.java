package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtility {
	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() { //synchronized for not overlapping
																		
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); // "./" represents directory
																										
		reporter.config().setReportName("7martsupermarket"); 
		extentReports.attachReporter(reporter); //attatches extendreports and extendSparkreports
		extentReports.setSystemInfo("Organization", "Obsqura"); 
		extentReports.setSystemInfo("Name", "Jismi");
		return extentReports; //returns a report
	}

}
