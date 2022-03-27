package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {

	public WebDriver driver;

	public Home(WebDriver driver) {
		this.driver = driver;
	}

	By alert = By.xpath("//button[text()='NO THANKS']");
	By login = By.xpath("//span[text()='Login']");
	By title = By.cssSelector("#content div div h2");

	public WebElement getLogin() {
		return driver.findElement(login);
	}

	public WebElement getAlert() {
		return driver.findElement(alert);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}
}
