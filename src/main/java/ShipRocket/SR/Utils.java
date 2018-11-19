package ShipRocket.SR;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

public class Utils {
	static WebDriver driver;
	public static String URL = "";
	final String FILE_UPLOADER = System.getProperty("user.dir") + "/resources/exe/fileUpload.exe";

	public void launchBrowser(String browser){

		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/resources/exe/chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("disable-infobars");
			driver = new ChromeDriver(option);
			//driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/resources/exe/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/resources/exe/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/resources/exe/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("safari"))
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/resources/exe/MicrosoftWebDriver.exe");
			driver = new SafariDriver();
		}
		return;
	}
	public WebDriver getDriver(){
		return driver;
	}
	//////////// Testing Environment

	public void launchDomain(String domain) {
		String qa = "http://anusha-qa.kartrocket.com/" ;
		String production = "https://app.shiprocket.in/";
		String staging = "http://krmct002.kartrocket.com/";
		{
			if(domain.equalsIgnoreCase("qa"))
			{
				URL = qa;
				driver.get(qa);
			}
			else if(domain.equalsIgnoreCase("production"))
			{
				URL = production;
				driver.get(production);
			}
			else if(domain.equalsIgnoreCase("staging"))
			{
				URL = staging;
				driver.get(staging);
			}
		}
	}

	/**
	 * @Desc - get the domain
	 */
	public void getDomain(String domain) {
		String qa = "http://anusha-qa.kartrocket.com" ;
		String production = "https://app.shiprocket.in/";
		String staging = "http://krmct002.kartrocket.com/";
		{
			if(domain.equalsIgnoreCase("qa"))
			{
				URL = qa;
			}
			else if(domain.equalsIgnoreCase("production"))
			{
				URL = production;
			}
			else if(domain.equalsIgnoreCase("staging"))
			{
				URL = staging;
			}
		}
	}

	/**
	 * File uploading feature
	 * Steps: for windows machine for chrome browser
	 * 1. upload(..path. of file..)
	 * 2. focusOnTheFileUploader()
	 * 3. uploadFileOnTheModal(....path. of file..)
	 * 4. killFileUploader() // it shall kill the process of the exe from task-manager of windows
	 */
	public void upload(String filePath) {
		focusOnTheFileUploader();
		uploadImageOnTheModal(filePath);
		killFileUploader();
	}

	private void focusOnTheFileUploader(){
		try{
			Runtime.getRuntime().exec(FILE_UPLOADER);
		}catch(Exception e){}
	}

	private void uploadImageOnTheModal(String filePath){
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		try{
			Thread.sleep(5000);
			focusOnTheFileUploader();
			//imitate mouse events like ENTER, CTRL+C, CTRL+V
			Robot robot = new Robot();
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(5000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(15000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void killFileUploader() {
		try {
			Thread.sleep(1000);
			Runtime.getRuntime().exec("taskkill /F /IM fileUpload.exe");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	/// read data from sheet csv


	public List<String> testdata_urlcheck(String cellNumber){	
		List<String> values = new ArrayList<>();

		try {
			String f1= (System.getProperty("user.dir") + "\\resources\\data\\parmanu_url.csv");       		
			File file = new File(f1);
			@SuppressWarnings("resource")
			BufferedReader bufRdr = new BufferedReader(new FileReader(file));
			String record = "" ;

			while ((record = bufRdr.readLine()) != null)
			{ 
				String fields[] = record.split(",");
				if (fields[0].equals(cellNumber)){
					for(int i = 1; i < fields.length; i++){
						values.add(fields[i]);	
					}
					break;
				}
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return values;
	}	
	

}