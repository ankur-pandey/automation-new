package ShipRocket.SR;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class OrderTestBulk {

	WebDriver driver;

	@Parameters({"browser", "domain"})

	@BeforeClass
	public void preLaunchActivities(){
		Utils util = new Utils();
		driver = util.getDriver();
	}

	@Test 

	public void bulkUpload()  throws InterruptedException{
		Utils data = new Utils();
		data = new Utils();
		String currentURL = Utils.URL;
		String link = data.testdata_urlcheck("3").get(0);
		currentURL = currentURL + link;
		driver.get(currentURL);

		Assert.assertTrue(currentURL.contains("processing"));
		System.out.println(currentURL+"order processing page succesful");

		
		
		Thread.sleep(7000);

		@SuppressWarnings("unused")
		OrderProcessing bulk = new OrderProcessing(driver);

		OrderProcessing.ClickOnBulkOrder();
		Thread.sleep(7000);
		String filePath = System.getProperty("user.dir")+"/resources/data/oo.csv".replace("/", "\\"); 
		OrderProcessing.TypeBulkFileBrowse(filePath);
		Thread.sleep(7000);
		
		OrderProcessing.ClickOnBulkUploadButton();
		Thread.sleep(7000);
		
		driver.navigate().refresh();
		Thread.sleep(7000);
		OrderProcessing.ClickOnSelectAllOrders();
		Thread.sleep(7000);
		OrderProcessing.ClickOnShipAllOrders();
		Thread.sleep(7000);
		OrderProcessing.ClickOnPickupRequest();
		Thread.sleep(7000);
	}
}