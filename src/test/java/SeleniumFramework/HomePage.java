package SeleniumFramework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import java.io.IOException;
import org.testng.annotations.Test;

import resources.Base;
import pageObjects.Home;
import pageObjects.SignIn;

public class HomePage extends Base {

	public WebDriver driver;

	private static Logger log = LogManager.getLogger(HomePage.class.getName());

	@Test
	public void validateSignin() throws IOException, InterruptedException {

		driver = initializeDriver();
		log.info("Driver is initialized");

		driver.get(prop.getProperty("url"));
		
		Home hm = new Home(driver);
		hm.getAlert().click();
		log.info("Alert Box is cancelled.");

		hm.getLogin().click();
		log.info("Login button clicked");

		SignIn si = new SignIn(driver);
		si.getEmail().sendKeys("jahanzab@gmail.com");
		log.info("Entered Username");

		si.getPassword().sendKeys("hello");
		log.info("Entered Password");

		si.getLogin().click();
		log.info("Login Submit");
		Assert.fail();
		driver.close();
	}

}
