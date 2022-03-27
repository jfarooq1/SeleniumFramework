package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	static ExtentSparkReporter reporter;
	static ExtentReports extent;

	public static ExtentReports config() {

		reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//reports//index.html");
		reporter.config().setReportName("Automation Report");
		reporter.config().setDocumentTitle("Test Execution Report");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;

	}

}
