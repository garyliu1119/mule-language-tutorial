/**
 * 
 */
package com.amgen.pes.util;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.Thread;
import java.util.HashMap;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.*;
/**
 * @author djyoti
 *
 */
public class VeevaAuditLog2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			// TODO Auto-generated method stub
		
		 // Optional, if not specified, WebDriver will search your path for chromedriver.
		 System.setProperty("webdriver.chrome.driver", "/Geko/VeevaAuditLogPOC/chromefiles/chromedriver.exe");
		 

		  String downloadFilepath = "c:\\Amgen\\download";
		  
	      HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	      chromePrefs.put("profile.default_content_settings.popups", 0);
	      chromePrefs.put("download.default_directory", downloadFilepath);
	      ChromeOptions options = new ChromeOptions();
	      HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
	      options.setExperimentalOption("prefs", chromePrefs);
	      options.addArguments("--test-type");
	  
	      DesiredCapabilities cap = DesiredCapabilities.chrome();
	      cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
	      cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	      cap.setCapability(ChromeOptions.CAPABILITY, options);
		  WebDriver driver =  new ChromeDriver(cap);  

		  driver.get("https://login.veevavault.com/auth/login");
		  Thread.sleep(5000);  
		  
		  String username = "svc-datamart@amgensbx.com";
		  String password = "Medcomm123@";
		  System.out.println("Step 1");
		  
		  driver.findElement(By.name("j_username")).sendKeys(username);
		  driver.findElement(By.name("j_password")).sendKeys(password);
		  driver.findElement(By.xpath("//*[@type='submit']")).click();
		  System.out.println("Step 2");
		  
		  String pageSource = driver.getPageSource();
		  int indexWWStart = pageSource.indexOf("var WHAT_WHAT = \"") + 17;
		  int indexWWEnd = pageSource.indexOf("\"",indexWWStart+2);
		  System.out.println("Step 3");
		  
		  
		  System.out.println(indexWWStart  + "  end " + indexWWEnd + "["  + pageSource.substring(indexWWStart, indexWWEnd)+ "]");
		 // String sURL = "https://amgensbx-medcomms-3.veevavault.com/ui/audit/document/csv?filterString=[{%22property%22:%22Date%22,%22eval%22:%22BETWEEN%22,%22evalLabel%22:%22is%20in%20the%20range%22,%22label%22:%22Timestamp%22,%22dataType%22:%22Date%22,%22values%22:[%222016-01-03%22,%222017-01-09%22],%22runtime%22:false},{%22property%22:%22Event%22,%22eval%22:%22IN%22,%22evalLabel%22:%22in%22,%22label%22:%22Event%22,%22dataType%22:%22Picklist%22,%22values%22:[%22DocAllVersionsDeleted%22],%22labels%22:[%22Delete%20All%20Document%20Versions%22],%22runtime%22:false}]&ww=" +pageSource.substring(indexWWStart, indexWWEnd) + "\"";
		  
		 // System.out.println("URL: " + sURL);
		  driver.get("https://amgensbx-medcomms-3.veevavault.com/ui/audit/document/csv?filterString=%5B%7B%22property%22%3A%22Date%22%2C%22eval%22%3A%22BETWEEN%22%2C%22evalLabel%22%3A%22is+in+the+range%22%2C%22label%22%3A%22Timestamp%22%2C%22dataType%22%3A%22Date%22%2C%22values%22%3A%5B%222017-05-01%22%2C%222017-05-31%22%5D%2C%22runtime%22%3Afalse%7D%5D&ww=" +pageSource.substring(indexWWStart, indexWWEnd) + "\"");
		  System.out.println("Step 4");
		  
		  //driver.page_source
		  System.out.println(driver.getPageSource());
		  System.out.println("Step 5");
		  
		  Thread.sleep(5000);  
		  driver.quit();
		} 
		catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

}
