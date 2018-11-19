package ShipRocket.SR;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginTest {

	WebDriver driver;

	@Parameters({"browser", "domain"})

	@BeforeTest
	public void preLaunchActivities(String browser, String domain){
		Utils util = new Utils();
		util.launchBrowser(browser);
		driver = util.getDriver();
		util.launchDomain(domain);

	}

	@Test 
	
	public void login_verify() throws Exception{
		Utils data = new Utils();
		data = new Utils();
		String currentURL = Utils.URL;
		String link = data.testdata_urlcheck("2").get(0);
		currentURL = currentURL + link;
		driver.get(currentURL);

		Assert.assertTrue(currentURL.contains("login"));
		System.out.println(currentURL+"login succesful");


		Thread.sleep(7000);
		driver.manage().window().maximize();

		LoginSR loginPage = new LoginSR(driver);

		/*loginPage.typeUsername("manoj.negi@kartrocket.com");

		loginPage.typePassword("manoj.negi");*/
		
		loginPage.typeUsername("surabhi@yopmail.com");

		loginPage.typePassword("123456");


		loginPage.ClickOnLogin();
		Thread.sleep(7000);

	}
}