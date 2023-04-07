package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ShowCartPage {
	public WebDriver driver;
	public ShowCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h3[@class='total-tech-savings-provider-body__heading--first']//span[1]")
	WebElement unlock;
	@FindBy(xpath="//button[@class='c-button c-button-primary c-button-md btn-lg']")
	WebElement addtotaltech;
	@FindBy(xpath="//span[@class='cart-label']")
	WebElement cartlink;
	@FindBy(xpath="//h2[@id='cart-order-summary']")
	WebElement ordersummary;
	@FindBy(xpath="(//span[@class='price-summary-line__content'])[1]")
	WebElement originalprice;
	@FindBy(xpath="(//span[@class='price-summary-line__content'])[2]")
	WebElement savings;
	@FindBy(xpath="(//span[@class='price-summary-line__content'])[3]")
	WebElement storepickup;
	@FindBy(xpath="(//span[@class='price-summary-line__content'])[4]")
	WebElement estimatedtax;
	@FindBy(css="div[class='below-the-line-item '] div:nth-child(2)")
	WebElement totalprice;
	
	public void CartLink() {
		cartlink.click();	
//		addtotaltech.click();
//		System.out.println(driver.getTitle());
		try {
			if(unlock.isDisplayed()) {
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				addtotaltech.click();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void GetPrice() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ordersummary));
//		Assert.assertEquals(driver.getTitle(), "Cart - Best Buy");
//		System.out.println("This is Your Cart Page");
		System.out.println("CART"+""+driver.getTitle());
		System.out.println("ORIGINAL PRICE FOR PRODUCTS : "+""+originalprice.getText());
		System.out.println(" SAVING AMOUNT FOR PRODUCTS : "+""+savings.getText());
		System.out.println("  PICKUP PRICE FOR PRODUCTS : "+""+storepickup.getText());
		System.out.println(" ESTIMATED TAX FOR PRODUCTS : "+""+estimatedtax.getText());
		System.out.println(" PAYMENT PRICE FOR PRODUCTS : "+""+totalprice.getText());
//		Assert.assertEquals(totalprice.getText(), "$559.98");
		System.out.println(totalprice.getText());
		
	}
}
