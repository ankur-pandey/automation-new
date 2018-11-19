package ShipRocket.SR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSR {




	WebDriver driver;


	By username = By.xpath("//input[@name='account_email']");
	By password = By.xpath("//input[@name='account_password']");
	By login =	By.xpath("//button[@type='submit']");



	public LoginSR(WebDriver driver)
	{
		this.driver = driver;
	}


	public void typeUsername(String user_name)
	{
		driver.findElement(username).sendKeys(user_name);
	}

	public void typePassword(String Password)
	{
		driver.findElement(password).sendKeys(Password);
	}

	public void ClickOnLogin()
	{	
		driver.findElement(login).click();
	}

}
