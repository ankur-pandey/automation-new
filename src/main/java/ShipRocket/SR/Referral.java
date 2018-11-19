package ShipRocket.SR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Referral {

	static WebDriver driver;

	public Referral(WebDriver driver){
		
		this.driver = driver;
	
	}

	static By referralEmail = By.xpath("(//input[@type='text'])[2]");
	
	static By referralSubmit  = By.xpath("//button[@type='submit'][text()='Send']");

	public static void typeReferralEmail(String Email){
		
		driver.findElement(referralEmail).sendKeys(Email);
	
	}

	public static void ClickOnReferralSubmit(){
		
		driver.findElement(referralSubmit).click();
	}
}