package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class CheckUrlPage {
	public WebDriver driver;
	public CheckUrlPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void BrokenUrl() {
//		driver.get("https://www.google.com/");
	      //get list of elements with anchor tag
	      List<WebElement> l = driver.findElements(By.tagName("a"));
	      //iterate links
	      for(int i=0; i<l.size(); i++) {
	         WebElement e = l.get(i);
	         //get URL of links with getAttribute()
	         String u = e.getAttribute("href");
	         // to catch MalFormedURLException
	         try{
	            //object of URL class
	            URL link = new URL(u);
	            // establish connection URL object
	            HttpURLConnection c = (HttpURLConnection)link.openConnection();
	            //have timeout
	            c.setConnectTimeout(1000);
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
	         catch (Exception ex) {
	         }
	      }
	}

}
