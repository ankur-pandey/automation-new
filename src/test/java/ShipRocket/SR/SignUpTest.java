package ShipRocket.SR;

import org.apache.poi.ss.formula.functions.Replace;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class SignUpTest {

	WebDriver driver;

	@Parameters({"browser", "domain"})

	@BeforeTest
	public void preLaunchActivities(String browser, String domain){
		Utils util = new Utils();
		util.launchBrowser(browser);
		driver = util.getDriver();
		util.launchDomain(domain);

	}

	@Parameters({"dbConnectionURL", "dbUsername", "dbPassword"})
	@Test 
	public void login_verify(String ConnectioString, String userName, String pwd) throws Exception{
		Utils data = new Utils();
		data = new Utils();
		String currentURL = Utils.URL;
		String link = data.testdata_urlcheck("1").get(0);
		currentURL = currentURL + link;
		driver.get(currentURL);

		Assert.assertTrue(currentURL.contains("register"));
		System.out.println(currentURL+"signup url");


		Thread.sleep(7000);
		driver.manage().window().maximize();

		@SuppressWarnings("unused")
		SignUp register = new SignUp(driver);
		SignUp.typeFirstName("automation");
		SignUp.typeLastName("test");
		SignUp.typeCompanytName("Internal Automation");
		SignUp.typeEmail("auto"+System.currentTimeMillis()/1000+"@yopmail.com");
		SignUp.typePassword("123456");
		SignUp.ClickOnsignUp();
		Thread.sleep(5000);
		Db db = new Db();
		String number = db.mobileNumber();
		Thread.sleep(7000);
		SignUp.typeMobile(number);
		Thread.sleep(7000);
		SignUp.ClickOnVerificationCode();

		String otp = db.getOTP(ConnectioString, userName, pwd, number);
		Thread.sleep(5000);
		SignUp.typeEnterOTP(otp);
		Thread.sleep(7000);
		SignUp.ClickOnVerifyPhone();
		Thread.sleep(7000);
		System.out.println("signup succesful");
		/*Thread.sleep(15000);
		String link1 = data.testdata_urlcheck("9").get(0);
		currentURL = currentURL + link1;
		driver.get(currentURL);
		Thread.sleep(7000);
		SignUp.typeEnterCBillingAdress("hello");
		SignUp.typeCBillingPincode("110088");
		Thread.sleep(7000);
		SignUp.typeEnterCBillingPhone("9999999999");
		Thread.sleep(7000);
		SignUp.ClickOnCBillingSubmit();
		Thread.sleep(7000);*/

	}
}