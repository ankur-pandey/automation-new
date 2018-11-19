package ShipRocket.SR;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrderCreationTest {

	WebDriver driver;

	@Parameters({"browser", "domain"})

	@BeforeClass
	public void preLaunchActivities(){
		Utils util = new Utils();
		driver = util.getDriver();
	}

	@Test 

	public void forwardOrder()  throws InterruptedException{
		Utils data = new Utils();
		data = new Utils();
		String currentURL = Utils.URL;
		String link = data.testdata_urlcheck("6").get(0);
		currentURL = currentURL + link;
		driver.get(currentURL);

		Thread.sleep(5000);

		OrderCreation ForwardOrder = new OrderCreation(driver);

		OrderCreation.TypeFOrderId("F" + System.currentTimeMillis());

		Thread.sleep(3000);

		OrderCreation.TypeFFN("AutoName");

		Thread.sleep(3000);

		OrderCreation.TypeFEmail("F"+System.currentTimeMillis()+"@yopmail.com");

		Thread.sleep(3000);

		OrderCreation.TypeFPhone("9888765432");

		Thread.sleep(3000);

		OrderCreation.TypeFAddress1("AutoAddress");

		Thread.sleep(3000);

		OrderCreation.TypeFPincode("110088");

		Thread.sleep(5000);

		OrderCreation.TypePName("F"+System.currentTimeMillis());

		Thread.sleep(5000);

		OrderCreation.TypePSku("F"+System.currentTimeMillis());

		Thread.sleep(3000);
		
		OrderCreation.TypePHSN("123456");
		
		Thread.sleep(3000);

		OrderCreation.TypePQuantity("1");

		Thread.sleep(3000);

		OrderCreation.TypePPrice("100");
		
		Thread.sleep(3000);
		
		OrderCreation.TypePWeight("1");
		
		Thread.sleep(3000);
		
		OrderCreation.TypePL("10");
		
		Thread.sleep(3000);
		
		OrderCreation.TypePB("11");
		
		Thread.sleep(3000);
		
		OrderCreation.TypePH("12");
		
		Thread.sleep(3000);
		
		OrderCreation.ClickOnPayment();
		
		Thread.sleep(3000);
		
		OrderCreation.ClickOnFFormSubmit();
		
		Thread.sleep(3000);
		
		driver.getCurrentUrl();
		System.out.println("currentURL");

	}
}