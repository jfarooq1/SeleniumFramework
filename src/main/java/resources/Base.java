package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.apache.commons.io.*;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		String path = System.getProperty("user.dir") + "//src//main//java//resources//enviornment.properties";
		FileInputStream fs = new FileInputStream(path);
		prop.load(fs);
		String browser = prop.getProperty("browser");

		// Choosing WebDriver

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//src//main//java//webdriver//chromedriver");

			driver = new ChromeDriver();
		}

		else if (browser == "firefox") {
			driver = new FirefoxDriver();
		}

		else if (browser == "ie") {
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}
	

	public void takeScreenshot(WebDriver driver, String testname) throws IOException {
		System.out.println("In screenshot");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "//reports//" + testname + ".png";
		org.apache.commons.io.FileUtils.copyFile(src, new File(destinationFile));

	}

}
