package ShipRocket.SR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChannelIntegration {

	static WebDriver driver;

	public ChannelIntegration(WebDriver driver) {
		this.driver = driver;
	}

	//kartrocket

	static By kartAPI = By.xpath("//input[@id='api_key']");

	public static  void TypeKartAPI(String kAPI) {

		driver.findElement(kartAPI).sendKeys(kAPI);

	}



	//Woocommerce
	static By wooStatus = By.xpath("//input[@id='order_status']");
	static By wooConsumerKey = By.xpath ("//input[@id='consumer_key']");
	static By wooConsumerSecretKey=By.xpath("//input[@id='consumer_secret']");	


	public static  void TypeWooStatus(String wooState) {

		driver.findElement(wooStatus).sendKeys(wooState);

	}



	public static  void TypeWooConsumerKey(String wooConsumerK) {

		driver.findElement(wooConsumerKey).sendKeys(wooConsumerK);

	}


	public static  void TypeWooConsumerSecretKey(String wooConsumerSK) {

		driver.findElement(wooConsumerSecretKey).sendKeys(wooConsumerSK);

	}
	// store url
	static By storeURL = By.xpath("//input[@id='store_url']");

	public static  void TypeStoreURL(String sURL) {

		driver.findElement(storeURL).sendKeys(sURL);

	}


	//submit

	static By submit = By.xpath("//button[@type='submit']");

	public static  void ClickOnSubmit()	{

		driver.findElement(submit).click();

	}

	//sync channel orders

	static By sync = By.xpath("//a[@ng-click='syncOrder()'][text()=' Orders']");
	public static  void ClickOnSync()	{

		driver.findElement(sync).click();

	}
}