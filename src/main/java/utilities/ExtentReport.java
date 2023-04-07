package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentReport {
	public static ExtentReports getExtentReport() {
		String extentReportPath=System.getProperty("user.dir")+ "\\reports\\Extentreport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath); 
		reporter.config().setReportName("BESTBUY Framework Automation Report");
		reporter.config().setDocumentTitle("BESTBUY Framework Automation Testing");
		ExtentReports extentReport=new ExtentReports();
		extentReport.attachReporter(reporter);
		return extentReport;
	}
}