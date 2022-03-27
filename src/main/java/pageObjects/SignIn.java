package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignIn {

	public WebDriver driver;

	public SignIn(WebDriver driver) {
		this.driver = driver;
	}

	By email = By.cssSelector("#user_email");
	By password = By.cssSelector("#user_password");
	By login = By.name("commit");

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLogin() {
		return driver.findElement(login);

	}

}
