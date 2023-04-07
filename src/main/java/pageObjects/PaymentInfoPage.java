package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PaymentInfoPage {
	public WebDriver driver;
	public PaymentInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[normalize-space()='Payment Information']")
	WebElement pagetitle;
	@FindBy(xpath="//input[@id='number']")
	WebElement cardnumber;
	@FindBy(xpath="//input[@id='first-name']")
	WebElement firstname;
	@FindBy(xpath="//input[@id='last-name']")
	WebElement lastname;
	@FindBy(xpath="//input[@id='address-input']")
	WebElement address;
	@FindBy(xpath="//select[@id='expMonth']")
	WebElement expmonth;
	@FindBy(xpath="//select[@id='expYear']")
	WebElement expyear;
	@FindBy(xpath="//input[@id='cvv']")
	WebElement cardcvv;
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	@FindBy(xpath="//select[@id='state']")
	WebElement state;
	@FindBy(xpath="//input[@id='postalCode']")
	WebElement zipcode;
	@FindBy(xpath="//button[@data-track='Place your Order - Contact Card']")
	WebElement placeorder;
	
//	public void getpagetitle() {
//		Assert.assertEquals(pagetitle.getText(), "Payment Information");
//	}
	public void EnterCardnumber(String CardNumber) {
		cardnumber.sendKeys(CardNumber);
	}
	public void EnterExpmonth(String Expmonth) {
		expmonth.sendKeys(Expmonth);
	}
	public void EnterExpyear(String Expyear) {
		expyear.sendKeys(Expyear);
	}
	public void EnterCCV(String Securitycode) {
		cardcvv.sendKeys(Securitycode);
	}
	public void EnterFirstname(String FirstName) {
		firstname.sendKeys(FirstName);
	}
	public void EnterLastname(String LastName) {
		lastname.sendKeys(LastName);
	}
	public void EnterAddr(String Addr) {
		address.sendKeys(Addr);
	}
	public void EnterCity(String City) {
		city.sendKeys(City);
	}
	public void EnterState(String State) {
		state.sendKeys(State);
	}
	public void EnterZipcode(String Zipcode) {
		zipcode.sendKeys(Zipcode);
	}
	public void PlaceOrder() {
		placeorder.click();
	}
}
