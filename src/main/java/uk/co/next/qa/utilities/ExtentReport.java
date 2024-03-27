package uk.co.next.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	public static ExtentReports generateExtentReport() {

		File extentReportPath = new File(
				System.getProperty("user.dir") + "//test-output//ExtentReport//report.html");

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportPath);

		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Next Report");
		sparkReporter.config().setReportName("Next Automation Test Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/YYYY hh:mm:ss");

		ExtentReports extentReports = new ExtentReports();

		extentReports.attachReporter(sparkReporter);

		Properties reportProp = new Properties();
		File reportPropPath = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\uk\\co\\next\\qa\\config\\config.properties");
		try {
			FileInputStream reportFis = new FileInputStream(reportPropPath);
			reportProp.load(reportFis);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		extentReports.setSystemInfo("Application URL", reportProp.getProperty("url"));
		extentReports.setSystemInfo("Browser Name ", reportProp.getProperty("BrowserName"));
		extentReports.setSystemInfo("Email ID", reportProp.getProperty("EmailId"));
		extentReports.setSystemInfo("Password", reportProp.getProperty("Password"));

		extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));

		return extentReports;

	}
}
