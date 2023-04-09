package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@data-lid='ubr_mby_signin_b']")
	WebElement signinlink;
	@FindBy(xpath="//h1[normalize-space()='Sign In to Best Buy']")
	WebElement signinpage;
	@FindBy(xpath="//input[@id='fld-e']")
	WebElement emailaddr;
	@FindBy(xpath="//input[@id='fld-p1']")
	WebElement password;
	@FindBy(xpath="//button[@data-track='Sign In']")
	WebElement signinbtn;
	@FindBy(xpath="//a[@data-track='Sign In - Error Message - Create Account Link']")
	WebElement noacclink;
	@FindBy(xpath="//a[@href='https://www.bestbuy.com']")
	WebElement homepage;
	@FindBy(xpath="//span[@class='v-p-right-xxs line-clamp']")
	WebElement logintest;
	@FindBy(xpath="//strong/div[contains(text(),'Sorry, something went wrong. Please try again.')]")
	WebElement loginwrong;
	@FindBy(xpath="//a[@href='https://www.bestbuy.com/?intl=nosplash']")
	WebElement returnhome;
	@FindBy(xpath="//span[@class='v-p-right-xxs line-clamp']")
	WebElement accountbutton;
	
	
	public void Siginlink() {
		signinlink.click();
	}
	public void Acclink() {
		accountbutton.click();
	}
	public void EnterEmailAddr(String Emailid) {
		Assert.assertEquals(driver.getTitle(), "Sign In to Best Buy");
		System.out.println("WELCOME TO BEST BUY Signin page");
		emailaddr.click();
		emailaddr.sendKeys(Emailid);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(emailaddr));
		emailaddr.click();
	}
	public void EnterPassword(String Password) {
		password.click();
		password.sendKeys(Password);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.click();
	}
	public void EnterInvalidPassword(String InvalidPassword) {
		password.clear();
		password.click();
		password.sendKeys(InvalidPassword);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.click();
	}
	public void SigninBtn() {
		signinbtn.click();

//			if(noacclink.isDisplayed()) {
//				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
//				wait.until(ExpectedConditions.visibilityOf(noacclink));	
//				Assert.assertEquals(noacclink.getText(), "create an account");
//				noacclink.click();
//				System.out.println("Account not Exist");
//			}else if(homepage.isDisplayed()) {
//				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
//				wait.until(ExpectedConditions.visibilityOf(homepage));								
//				homepage.click();
//				Assert.assertEquals(logintest.getText(), "Hi,Testuser");
//				System.out.println("User Loggedin successfuly");
//			}else if(loginwrong.isDisplayed()) {
				Assert.assertEquals(loginwrong.getText(), "Sorry, something went wrong. Please try again.");
				System.out.println("Sorry, something went wrong in signin page");
				returnhome.click();
//			}
		
	}
}
