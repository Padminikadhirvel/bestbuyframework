package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class CheckUrlPage {
	public WebDriver driver;
	public CheckUrlPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void BrokenUrl() throws IOException {
//		driver.get("https://www.google.com/");
	      //get list of elements with anchor tag
	      List<WebElement> l = driver.findElements(By.tagName("a"));
	      //iterate links
	      System.out.println(l.size());
	      for(int i=0; i<l.size(); i++) {
	         WebElement ele = l.get(i);
	         //get URL of links with getAttribute()
	         String u = ele.getAttribute("href");
	         // to catch MalFormedURLException
	        
	         try{
	            //object of URL class
	            URL link = new URL(u);
	            // establish connection URL object
	            HttpURLConnection c = (HttpURLConnection)link.openConnection();
	            //have timeout
	            c.setConnectTimeout(2000);
	            // connection began
	            c.connect();
	            //getResponseCode() to obtain response code
	            if(c.getResponseCode()== 200) {
	               System.out.println(u+" − "+ c.getResponseMessage()+": Valid URL");
	            }
	            if(c.getResponseCode()== 404) {
	               System.out.println(u+" − "+c.getResponseMessage()+": Broken URL");
	            }
	         }
	         catch (StaleElementReferenceException e) {
	        	 WebElement ele1 = l.get(i);
	        	 String u1 = ele1.getAttribute("href");
	        	 System.out.println("The string entered from catch block is - " +u);
	         }
	      }
	}

}
