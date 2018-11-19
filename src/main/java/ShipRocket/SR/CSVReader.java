package ShipRocket.SR;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class CSVReader { 

	//order import
	@SuppressWarnings("unused")
	public static String uploadUserImportCSV()

	{
		String f1 = (System.getProperty("user.dir") + "\\resources\\data\\oo.csv");
		File file = new File(f1);
		return f1;
	}
	//SR URL's

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