package uk.co.next.qa.utilities;

import java.awt.Desktop;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListeners implements ITestListener {
	ExtentReports extentReport;
	ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {
		extentReport = ExtentReport.generateExtentReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName + " Test Excecution get Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.PASS, testName + " Test got Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();

		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

		String destination = ScreenShot.captureScreenShot(driver, testName);
		extentTest.addScreenCaptureFromPath(destination);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testName + " Test got Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName + " Test get Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();

		String extentReportPath = System.getProperty("user.dir") + "\\test-output\\ExtentReport\\report.html";
		File extentReportFile = new File(extentReportPath);

		try {
			Desktop.getDesktop().browse(extentReportFile.toURI());
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

}
