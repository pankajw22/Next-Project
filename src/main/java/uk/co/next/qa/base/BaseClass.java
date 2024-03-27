package uk.co.next.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	private WebDriver driver;
	public Properties prop;
	public Properties dataprop;

	public WebDriver launchBrowserAndOpenApplication() {
		String browserName = prop.getProperty("BrowserName");
		String driverPath = System.getProperty("user.dir") + "\\driver\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", driverPath);

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");

		if (browserName.equals("chrome"))
			driver = new ChromeDriver(opt);
		else if (browserName.equals("firefox"))
			driver = new FirefoxDriver();
		else if (browserName.equals("edge"))
			driver = new EdgeDriver();
		else
			System.out.println("Enter the Valid Broser Name");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(prop.getProperty("url"));

		return driver;
	}

	public BaseClass() {
		prop = new Properties();
		File configpath = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\uk\\co\\next\\qa\\config\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(configpath);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		dataprop = new Properties();
		File datapath = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\uk\\co\\next\\qa\\testdata\\testdata.properties");
		try {
			FileInputStream datafis = new FileInputStream(datapath);
			dataprop.load(datafis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
