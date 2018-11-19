package ShipRocket.SR;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ReferralTest {

	WebDriver driver;

	@Parameters({"browser", "domain"})

	@BeforeTest
	public void preLaunchActivities(String browser, String domain){
		Utils util = new Utils();
		
		driver = util.getDriver();

	}

	
	@Test 
	public void referral() throws Exception{
		Utils data = new Utils();
		data = new Utils();
		String currentURL = Utils.URL;
		String link = data.testdata_urlcheck("7").get(0);
		currentURL = currentURL + link;
		driver.get(currentURL);
		Thread.sleep(5000);		
		
		
		@SuppressWarnings("unused")
		Referral refer = new Referral(driver);

		Referral.typeReferralEmail("auto"+System.currentTimeMillis()/1000+"@yopmail.com");
		
		Thread.sleep(5000);
		
		Referral.ClickOnReferralSubmit();
	}
}