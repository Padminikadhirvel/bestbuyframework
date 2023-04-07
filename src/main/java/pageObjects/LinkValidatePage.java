package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.*;


public class LinkValidatePage {
	public WebDriver driver; 
	public LinkValidatePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
		
	public void ValidateLinks() 
	{
		List<WebElement> footerLinks=driver.findElements(By.xpath("//div[@class='flex justify-content-start']/a"));
				
		
		ArrayList<String> Values=new ArrayList<String>();
		Values.add("Accessibility");
		Values.add("Terms & Conditions");
		Values.add("Privacy");
		Values.add("Interest-Based Ads");
		Values.add("State Privacy Rights");
		Values.add("CA Do Not Sell/Share My Personal Information");
		Values.add("Limit Use of My Sensitive Personal Information");
		Values.add("Targeted Advertising Opt Out");
		Values.add("CA Supply Chain Transparency Act");
		
		ArrayList<String> actual=new ArrayList<String>();
		for(WebElement l1:footerLinks) 
		{
			System.out.println(l1.getText());
			actual.add(l1.getText().trim());
		}
		
		//Comparing Text of Expected Links with the Actual Links
		if(Values.equals(actual)) 
		{
			System.out.println("Links are matching with home page bottom links");
		}
		else 
		{
			System.out.println("Links are not matching with home page bottom links");
		}
	}
		

}
