package ShipRocket.SR;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class ChannelOrderTest {

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

		String link = data.testdata_urlcheck("8").get(0);

		currentURL = currentURL + link;

		driver.get(currentURL);

		Assert.assertTrue(currentURL.contains("channels"));

		System.out.println(currentURL+"channel integration Page");

		Thread.sleep(7000);

		@SuppressWarnings("unused")

		ChannelIntegration channel = new ChannelIntegration(driver);
		
		ChannelIntegration.TypeKartAPI("6512bd43d9caa6e02c990b0a82652dca");
		
		ChannelIntegration.TypeStoreURL("http://anushathegreat.kartrocket.co/");
		
		Thread.sleep(7000);
		
/*ChannelIntegration.TypeWooStatus("Pending Payment");
		
		Thread.sleep(7000);

		ChannelIntegration.TypeWooConsumerKey("ck_72903a8d880b9494fc9b3b420eaeefdff63c42bc");
		
		Thread.sleep(7000);
		
		ChannelIntegration.TypeWooConsumerSecretKey("cs_4e012ac4ba5eb38120eb6b180895ca5d54c8f4e0");
		
		Thread.sleep(7000); */
		
		ChannelIntegration.ClickOnSubmit();	
		
		Thread.sleep(7000);
		
		driver.get("http://krmct002.kartrocket.com/orders/processing?page=1&perPage=15&shop=&ids=");
		
		/*String link1 = data.testdata_urlcheck("3").get(0);

		currentURL = currentURL + link1;

		driver.get(currentURL);*/
		
		// ChannelIntegration.ClickOnSync();
		
		Thread.sleep(7000); 
		

		
		
		
		@SuppressWarnings("unused")
		OrderProcessing bulk = new OrderProcessing(driver);
		//driver.navigate().refresh();
		
		
		OrderProcessing.ClickOnSingleSelectOrders();
		
		Thread.sleep(7000);
		
		OrderProcessing.ClickOnSingleShipNow();
		
		Thread.sleep(7000);
		
		OrderProcessing.ClickOnSelectShippingPartner();
		
		Thread.sleep(7000);
		
		OrderProcessing.ClickOnSinglePickUpRequest();
	
	}

}