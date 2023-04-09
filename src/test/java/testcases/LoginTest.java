package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.AccountaddPage;
import pageObjects.LoginPage;

public class LoginTest extends BaseClass{
	
	
	@Test(priority=1)
	public void PageEntryOperation() {
		AccountaddPage addacc=new AccountaddPage(driver);
		addacc.SelectCountry();
		addacc.AccountLink();		
	}
	@Test(priority=2)
	public void LoginOperation(){
		LoginPage login=new LoginPage(driver);
		login.Siginlink();
		login.EnterEmailAddr(prop.getProperty("Emailid"));
		login.EnterPassword(prop.getProperty("Password"));
		login.SigninBtn();
				
	}
	@Test(priority=3)
	public void InvalidLoginOperation() {
		LoginPage login=new LoginPage(driver);
		login.Acclink();
		login.Siginlink();
		login.EnterEmailAddr(prop.getProperty("Emailid"));
		login.EnterPassword(prop.getProperty("InvalidPwd"));
		login.SigninBtn();
		
	}
}
