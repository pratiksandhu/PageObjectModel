package extentReportListener;




import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.Util;


public class ExtentReportListener extends TestListenerAdapter
{

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;


	
	public void onStart(ITestContext testContext)
	{

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date date = new Date();
		String timestamp = dateFormat.format(date);
		//String reportFileName = "/ExtentReport_" + timestamp + ".html";

		String reportFileName = "/ExtentReport.html";
		String reportFilePath = "Reports" + reportFileName; // Relative path of the report
		
     
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/" +reportFilePath);//specify location of the report

		sparkReporter.config().setDocumentTitle("Automation Report"); // Tile of report
		sparkReporter.config().setReportName("POM Testing Report"); // name of the report
		sparkReporter.config().setTimelineEnabled(true);
		sparkReporter.config().setTimeStampFormat("yyyy/MM/dd");
		//htmlReporter.config().setTheme(Theme.DARK);

		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Project Name","POMByNaveen");
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","pratik");

	}

	public void onTestSuccess(ITestResult result)
	{
		//test=extent.createTest(result.getClass().getName());
		//test.createNode(result.getName());
		test=extent.createTest(result.getName()); // create new entry in the report
		test.assignCategory("Passed Test Cases"); 
		test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
	}

	public void onTestFailure(ITestResult result)
	{

		test=extent.createTest(result.getName()); // create new entry in the report
		test.assignCategory("Failed Test Cases"); 
		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
		try {
			String screenshotPath = Util.takeScreenshotAtEndOfTest(); // Captures screenshot and returns the path
			String relativeScreenshotPath = "./screenshots/" + new File(screenshotPath).getName();
			test.addScreenCaptureFromPath(relativeScreenshotPath, "Test Failure Screenshot"); // Add screenshot to the report
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName()); // create new entry in the report
		test.assignCategory("Skipped Test Cases");
		test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
	}

	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}

}