package ShipRocket.SR;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class OrderTest {

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
		CSVReader data = new CSVReader();
		data = new CSVReader();
		String currentURL = Utils.URL;
		String link = data.testdata_urlcheck("8").get(0);
		currentURL = currentURL + link;
		driver.get(currentURL);

		Assert.assertTrue(currentURL.contains("orders"));
		System.out.println(currentURL+"orders");

		Thread.sleep(7000);


	}
}