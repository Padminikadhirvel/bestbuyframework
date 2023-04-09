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

public class GuestCheckOutPage {
	public WebDriver driver;
	public GuestCheckOutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[normalize-space()='Checkout']")
	WebElement checkout;
	@FindBy(xpath="//button[normalize-space()='Continue as Guest']")
	WebElement guestaccount;
	@FindBy(xpath="//span[normalize-space()='Getting your order']")
	WebElement getorder;
//	@FindBy(xpath="//div[@class='spu-location-card__location-group-title']")
//	WebElement pickupmsg;
	@FindBy(xpath="//button[@data-track='Change Store']/span")
	WebElement changepickulocation;
	@FindBy(xpath="//div[@class='css-901oao r-qzigq0'][normalize-space()='2']")
	WebElement nextshop;
	@FindBy(xpath="//div[contains(text(),'Select This Location')]")
	WebElement selectlocation;
	@FindBy(xpath="//button[@data-test='in-store']")
	WebElement instore;
	@FindBy(xpath="//button[@data-test='curbside']")
	WebElement curbside;
	@FindBy(xpath="//span[contains(text(),'Add a new pickup person')]")
	WebElement Addpickupperson;
	@FindBy(xpath="//input[@id='firstName']")
	WebElement pickpersonfname;
	@FindBy(xpath="//input[@id='lastName']")
	WebElement pickpersonlname;
	@FindBy(xpath="//input[@id='phoneNumber']")
	WebElement pickpersonmobno;
	@FindBy(xpath="//input[@id='emailAddress']")
	WebElement pickpersonemail;
	@FindBy(xpath="//button[@data-track='Pickup: Save pick up person']")
	WebElement pickpersonapply;
	@FindBy(xpath="//p[@data-test='pickupPersonMessage']/span")
	WebElement pickpersonmsg;
	@FindBy(xpath="//input[@id='user.emailAddress']")
	WebElement emaiaddr;
	@FindBy(xpath="//input[@id='user.phone']")
	WebElement mobileno;
	@FindBy(xpath="//button[@class='btn btn-lg btn-block btn-secondary']")
	WebElement continuepayment;
	@FindBy(xpath="//div/span[contains(text(),'Sorry, there was a problem. Please try that again.')]")
	WebElement continuepaymentwrong;
	@FindBy(xpath="//a[@href='/cart']")
	WebElement returncart;
	
	
	public void CheckoutBtn() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		checkout.click();
		guestaccount.click();
	}
	
	public void ChangePickupMethod() {
		driver.navigate().refresh();
		Assert.assertEquals(driver.getTitle(), "Sign In to Best Buy");
		System.out.println("WELCOME TO BESTBUY Checkout Page");

//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,300)");
//		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", curbside);
		curbside.click();
	}
	public void ChangePickupLocation() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(changepickulocation));
		changepickulocation.click();
		wait.until(ExpectedConditions.elementToBeClickable(nextshop));
		nextshop.click();
		wait.until(ExpectedConditions.elementToBeClickable(selectlocation));
		selectlocation.click();
	}
	public void AddPickPerson() {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", Addpickupperson);
			Addpickupperson.click();
			}
		

	public void EnterPickFname(String Pfname) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(pickpersonfname));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", pickpersonfname);
		pickpersonfname.sendKeys(Pfname);
	}
	public void EnterPickLname(String Plname) {
		pickpersonlname.sendKeys(Plname);
	}
	public void EnterPickMobno(String Pmobno) {
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(300,800)");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", Addpickupperson);
		pickpersonmobno.sendKeys(Pmobno);
	}	
	public void EnterPickEmail(String Pemail) {
		pickpersonemail.sendKeys(Pemail);
	}	
	public void PickPersonApply() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", pickpersonapply);
		pickpersonapply.click();
		System.out.println(pickpersonmsg.getText());
	}	
	public void UserEmaiAddr(String Emailid) {
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(800,1200)");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", emaiaddr);
		emaiaddr.sendKeys(Emailid);		
	}
	public void UserMobileno(String Mobileno) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", mobileno);
		mobileno.sendKeys(Mobileno);
	}
	public void ContinuePayment() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(continuepayment));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", continuepayment);
		continuepayment.click();
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", continuepaymentwrong);
		if(continuepaymentwrong.isDisplayed()) {
			Assert.assertEquals(continuepaymentwrong.getText(), "Sorry, there was a problem. Please try that again.");
			System.out.println("There was a problem in signin. Can't continue payment.");
		}
		
	}
}
