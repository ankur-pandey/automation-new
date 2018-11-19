package ShipRocket.SR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderProcessing {

	static WebDriver driver;

	public OrderProcessing(WebDriver driver) {
		this.driver = driver;
	}

	//generic actions for single
	static By singleSelectOrders = By.xpath("(//span[@class='fa fa-check'])[2]");
	static By singleShipNow = By.xpath ("//button[@class='btn label-generate-btn btn-sm ph-xl btn-blue mb-sm ']");
	static By singleCreateInvoice=By.xpath("(//a[@class= 'invoice-generate-btn btn-xs'])[2]");	
	static By selectShippingPartner = By.xpath("//button[@class='btn btn-sm ph-xl btn-blue']");
	static By singlePickUpRequest = By.xpath("//button[text()='Request Pickup']");
	
	public static  void ClickOnSingleSelectOrders()
	{
		driver.findElement(singleSelectOrders).click();
	}
	
	public static  void ClickOnSingleShipNow()
	{
		driver.findElement(singleShipNow).click();
	}
	
	public static  void ClickOnSingleCreateInvoice()
	{
		driver.findElement(singleCreateInvoice).click();
	}
	
	public static  void ClickOnSelectShippingPartner()
	{
		driver.findElement(selectShippingPartner).click();
	}
	
	public static  void ClickOnSinglePickUpRequest()
	{
		driver.findElement(singlePickUpRequest).click();
	}
	
	//generic actions for bulk
	static By allSelectOrders = By.xpath("(//span[@class='fa fa-check'])[1]");
	static By allShipOrders = By.xpath("//button[@type='button'][text()='Ship']");
	static By pickupRequest = By.xpath("//button[@ng-if='showBulkInfoRemove'][text()='Request Pickups']");


	public static  void ClickOnSelectAllOrders()
	{
		driver.findElement(allSelectOrders).click();
	}

	public static  void ClickOnShipAllOrders()
	{
		driver.findElement(allShipOrders).click();
	}

	public static void ClickOnPickupRequest()

	{
		driver.findElement(pickupRequest).click();
	}

	//Bulk Upload Orders 

	static By bulkOrder= By.xpath("//span[@class='btn btn-default upload pfx']");
	static By bulkFileBrowse= By.xpath("//label[@for='fileUpload']");
	static By bulkUploadButton = By.xpath("//button[@class='btn btn-primary'][text()='Upload']");

	public static  void ClickOnBulkOrder()
	{
		driver.findElement(bulkOrder).click();
	}

	public static  void TypeBulkFileBrowse(String filePath) {
		try {
			System.out.println("uploading file: " + filePath);
			driver.findElement(bulkFileBrowse).click();

			Utils utils = new Utils();
			utils.upload(filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ClickOnBulkUploadButton()
	{
		driver.findElement(bulkUploadButton).click();
	}
}