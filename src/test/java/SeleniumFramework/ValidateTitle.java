package SeleniumFramework;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.Home;

import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import resources.Base;

public class ValidateTitle extends Base {
	
	private static Logger log = LogManager.getLogger(ValidateTitle.class.getName());
	public WebDriver driver;

	@Test
	public void Validate() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		Home h = new Home(driver);
		h.getAlert().click();
		log.info("Verifying Title");
		String title=h.getTitle().getText();
		log.info("Title is "+title);
		log.info("Title Done");
		driver.close();
	}

	
}
