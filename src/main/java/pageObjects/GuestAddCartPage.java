package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GuestAddCartPage {
	public WebDriver driver;
	public GuestAddCartPage( WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='survey_content']")
	WebElement surveycontent;
	@FindBy(xpath="//button[@id='survey_invite_no']")
	WebElement surveydismiss;
	@FindBy(xpath="//input[@id='gh-search-input']")
	WebElement enterproduct;
	@FindBy(xpath="//span[@class='header-search-icon']//*[name()='svg']")
	WebElement searchproduct;
	@FindBy(xpath="//a[normalize-space()='Sony - 55\" Class X75K 4K HDR LED Google TV']")
	WebElement sonytv;
	
	
//	@FindBy(xpath="(//button[@type='button'][normalize-space()='Add to Cart'])[1]")
	@FindBy(xpath="//button[normalize-space()='Add to Cart']")
	WebElement addtocart;
	@FindBy(xpath="//button[@data-track='Attach Modal: Continue shopping']")
	WebElement continueshopping;
	@FindBy(xpath="//span[@class='cart-label']")
	WebElement gotocart;
	@FindBy(xpath="//button[normalize-space()='Continue as Guest']")
	WebElement guestlink;
	
	@FindBy(xpath="//button[@aria-label='Menu']")
	WebElement menulink;
	@FindBy(xpath="//button[normalize-space()='Brands']")
	WebElement brandlink;
	@FindBy(xpath="//a[@data-lid='ubr_shp_int']")
	WebElement intellink;
	@FindBy(xpath="//a[@class='link-element'][normalize-space()='Laptops']")
	WebElement laptopslink;
	@FindBy(xpath="//a[contains(text(),'HP - 15.6\" Touch-Screen Laptop - Intel Core i5 - 8')]")
	WebElement laptop;
	@FindBy(xpath="body > div:nth-child(5) > main:nth-child(2) > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(12) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > strong:nth-child(1)")
	WebElement availablity;
	@FindBy(xpath="//button[@data-lid='ubr_tv']")
	WebElement tvhomelink;
	@FindBy(xpath="//button[@data-lid='ubr_tv_av']")
	WebElement tvlink;
	@FindBy(xpath="//a[@data-lid='ubr_tv_av_prj']")
	WebElement tvprojectorlink;
	@FindBy(xpath="(//a[contains(text(),'Samsung - The Freestyle FHD HDR Smart Portable Pro')])[1]")
	WebElement projector;
	
	public void EnterProduct(String Product) {
		
		enterproduct.clear();
		enterproduct.sendKeys(Product);
		searchproduct.click();
		Assert.assertEquals(driver.getTitle(), "sony tv - Best Buy");
		System.out.println("WELCOM TO BESTBUY Home Page");
//		try {
//			if(surveycontent.isDisplayed()) {
//				surveydismiss.click();
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	public void SearchProduct() {
//		Actions action = new Actions(driver);

		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(sonytv));
		sonytv.click();
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,2000)");
//		action.doubleClick(samsungtv).build().perform();
		//wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(addtocart));
		//addtocart.click();
	}
	public void GetMenu() {
		menulink.click();
	}
	public void SelectBrand() {
		brandlink.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(intellink));
		intellink.click();
		Assert.assertEquals(driver.getTitle(), "Intel: Intel Powered Laptops & Desktops - Best Buy");
		System.out.println("WELCOME TO BESTBUY Intel Brand Page");
//		Assert.assertEquals(driver.getTitle(), "Sony Store: Sony Electronics & Entertainment - Best Buy");
//		System.out.println("This is Your Sony Brand Page");
		
	}
	public void SelectSonyproduct() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(laptopslink));
		laptopslink.click();
//		 wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(laptop));
//		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", laptop);
		laptop.click();
	}
	public void SelectTvDept() {
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(tvhomelink));
			tvhomelink.click();
			tvlink.click();
			tvprojectorlink.click();
			projector.click();
			Assert.assertEquals(driver.getTitle(), "Samsung The Freestyle FHD HDR Smart Portable Projector White SP-LSP3BLAXZA - Best Buy");
			System.out.println("WELCOME TO BESTBUY Projector Department Page");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void AddtoCart() {		
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,1500)");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", addtocart);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(addtocart));
		addtocart.click();
		}	
	public void ContinueShop() {
		continueshopping.click();
	}
}
