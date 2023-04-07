package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



import org.openqa.selenium.JavascriptExecutor;
public class AccountaddPage {
	public WebDriver driver;
	public AccountaddPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='United States']")
	WebElement selectlcountry;
	@FindBy(xpath="//span[@class='v-p-right-xxs line-clamp']")
	WebElement accountbutton;
	@FindBy(xpath="//a[@href='/identity/global/createAccount']")
	WebElement createaccountlink;
	@FindBy(xpath="//input[@id='firstName']")
	WebElement firstname;
	@FindBy(xpath="//input[@id='lastName']")
	WebElement lastname;
	@FindBy(xpath="//input[@id='email']")
	WebElement emailid;
	@FindBy(xpath="//input[@id='fld-p1']")
	WebElement pwd;
	@FindBy(xpath="//input[@id='reenterPassword']")
	WebElement confirmpwd;
	@FindBy(xpath="//input[@id='phone']")
	WebElement mobileno;
	@FindBy(xpath="//button[@data-track='Create Account']")
	WebElement createaccountbtn;
	@FindBy(xpath="//span[@class='v-p-right-xxs line-clamp']")
	WebElement logintest;
	@FindBy(xpath="//button[@id='logout-button']")
	WebElement signout;
	@FindBy(xpath="//a[@data-track='Create Account - Error Message - Sign In Link']")
	WebElement userexist;
	@FindBy(xpath="//a[normalize-space()='Return to previous page']")
	WebElement returnhome;
	
	
	public void SelectCountry() {
		selectlcountry.click();			
	}
	public void AccountLink() {
		accountbutton.click();
	}
	public void CreateAccountLink() {
		createaccountlink.click();
	}
	public void EnterFirstName(String Firstname) {
		firstname.sendKeys(Firstname);
	}
	public void EnterLastName(String Lastname) {
		lastname.sendKeys(Lastname);
	}
	public void EnterEmailId(String Emailid) {
		emailid.sendKeys(Emailid);
	}
	public void EnterPassword(String Password) {
		pwd.sendKeys(Password);
	}
	public void EnterConfirmPwd(String Confirmpwd) {
		confirmpwd.sendKeys(Confirmpwd);
	}
	public void EnterMobileNo(String Mobileno) {
		mobileno.sendKeys(Mobileno);
	}
	public void CreateAccBtn() {
		createaccountbtn.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		if(returnhome.isDisplayed()) {
			Assert.assertEquals(returnhome.getText(), "Return to previous page");
			System.out.println("User already exist");
			returnhome.click();
		}else if(logintest.isDisplayed())
				{
					Assert.assertEquals(logintest.getText(), "Hi,Testuser");
					System.out.println("User Loggedin successfuly");
					signout.click();
				}
	}

}
