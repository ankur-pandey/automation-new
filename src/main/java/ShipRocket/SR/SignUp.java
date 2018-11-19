package ShipRocket.SR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp {

	static WebDriver driver;

	public SignUp(WebDriver driver)
	{
		this.driver = driver;
	}

	static By firstName = By.xpath("(//input[@type='text'])[1]");
	static By lastName  = By.xpath("(//input[@type='text'])[2]");
	static By companyName = By.xpath("(//input[@type='text'])[3]");
	static By emailID = By.xpath("//input[@type='email']");
	static By password = By.xpath("//input[@type='password']");
	static By signUp = By.xpath("//button[@id='signUp']");
	static By mobile = By.xpath("//input[@name='mobile']");
	static By verificationCode = By.xpath("//button[text()='Send Verification Code']");
	static By enterOTP = By.xpath("//input[@placeholder='Enter OTP']");
	static By verifyPhone  = By.xpath("(//button[@type='submit'])[3]");

	public static void typeFirstName(String fname){

		driver.findElement(firstName).sendKeys(fname);

	}

	public static void typeLastName(String lname){

		driver.findElement(lastName).sendKeys(lname);

	}

	public static void typeCompanytName(String cname)
	{
		driver.findElement(companyName).sendKeys(cname);
	}

	public static void typeEmail(String cname)
	{
		driver.findElement(emailID).sendKeys(cname);
	}

	public static void typePassword(String cname)
	{
		driver.findElement(password).sendKeys(cname);
	}


	public static void ClickOnsignUp()
	{
		driver.findElement(signUp).click();
	}

	public static void typeMobile(String num)	{
		driver.findElement(mobile).sendKeys(num);
	}

	public static void ClickOnVerificationCode() {
		driver.findElement(verificationCode).click();
	}
	public static void typeEnterOTP(String otp)
	{
		driver.findElement(enterOTP).sendKeys(otp);
	}
	public static void ClickOnVerifyPhone() {
		driver.findElement(verifyPhone).click();
	}
	
	
	
	//company info
	
	
	static By cBillingAdress  = By.xpath("//input[@ng-model='company.billingAddress.addressLine1']");
	static By cBillingPincode = By.xpath("//input[@ng-model='company.billingAddress.pinCode']");
	static By cBillingPhone = By.xpath("//input[@ng-model='company.billingAddress.phone']");
	static By cBillingSubmit = By.xpath("//button[@ng-click='company.submit($event)']");

	public static void typeEnterCBillingAdress(String billingAdress)
	{
		driver.findElement(cBillingAdress).sendKeys(billingAdress);
	}
	public static void typeCBillingPincode(String billingPincode)
	{
		driver.findElement(cBillingPincode).sendKeys(billingPincode);
	}
	public static void typeEnterCBillingPhone(String billingPhone)
	{
		driver.findElement(cBillingPhone).sendKeys(billingPhone);
	}
	public static void ClickOnCBillingSubmit() {
		driver.findElement(cBillingSubmit).click();
	}
	
	
	
	
	
	
}
