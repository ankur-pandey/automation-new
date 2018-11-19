package ShipRocket.SR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderCreation {

	static WebDriver driver;


	// CustomerDetails
	static By fOrderId = By.xpath("//input[@id='form_order_id']");
	static By fFN = By.xpath("//input[@id='form_first_name']");
	static By fEmail = By.xpath("//input[@id='form_email']");
	static By fPhone = By.xpath("//input[@id='form_mobile']");
	static 	By fAddress1 = By.xpath("//input[@id='form_address_1']");
	static 	By fPincode = By.xpath("//input[@id='form_post_code']");

	public OrderCreation(WebDriver driver) {
		this.driver = driver;
	}

	public static void TypeFOrderId(String orderId)
	{
		driver.findElement(fOrderId).sendKeys(orderId);
	}

	public static  void TypeFFN(String name)
	{
		driver.findElement(fFN).sendKeys(name);
	}
	public static  void TypeFEmail(String email)
	{
		driver.findElement(fEmail).sendKeys(email);
	}
	public static  void TypeFPhone(String phone)
	{
		driver.findElement(fPhone).sendKeys(phone);
	}
	public static  void TypeFAddress1(String address)
	{
		driver.findElement(fAddress1).sendKeys(address);
	}
	public static  void TypeFPincode(String pincode)
	{
		driver.findElement(fPincode).sendKeys(pincode);
	}

	// Product Details
	static By pName = By.xpath("//input[@name='order_items.0.name']");
	static By pSku = By.xpath("//input[@placeholder='Enter SKU']");
	static By pHSN = By.xpath("//input[@id='form_enter_hsn']");
	static By pQuantity = By.xpath("//input[@name='order_items.0.units']");
	static By pPrice = By.xpath("//input[@name='order_items.0.selling_price']");

	public static void TypePName(String name)
	{
		driver.findElement(pName).sendKeys(name);
	}

	public static void TypePSku(String sku)
	{
		driver.findElement(pSku).sendKeys(sku);
	}
	public static void TypePHSN(String hsn)
	{
		driver.findElement(pHSN).sendKeys(hsn);
	}
	public static void TypePQuantity(String quantity)
	{
		driver.findElement(pQuantity).sendKeys(quantity);
	}
	public static void TypePPrice(String price)
	{
		driver.findElement(pPrice).sendKeys(price);
	}


	// Weight & Dimension Details

	static By pWeight = By.xpath("//input[@name='weight']");
	static By pL = By.xpath("//input[@name='length']");
	static By pB = By.xpath("//input[@name='breadth']");
	static By pH = By.xpath("//input[@name='height']");

	public static void TypePWeight(String weight)
	{
		driver.findElement(pWeight).sendKeys(weight);
	}

	public static void TypePL(String length)
	{
		driver.findElement(pL).sendKeys(length);
	}

	public static void TypePB(String breadth)
	{
		driver.findElement(pB).sendKeys(breadth);
	}

	public static void TypePH(String height)
	{
		driver.findElement(pH).sendKeys(height);
	}

	// Payment Details

	static By payment = By.xpath("//select[@id='form_payment_method']/option[2]");
	
	public static void ClickOnPayment()
	{	
		driver.findElement(payment).click();
	}

	//submit form
	static By fFormSubmit = By.xpath("//button[@id='form_add_order']");

	public static void ClickOnFFormSubmit()
	{	
		driver.findElement(fFormSubmit).click();
	}


}