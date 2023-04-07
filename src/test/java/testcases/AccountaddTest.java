package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.AccountaddPage;

public class AccountaddTest extends BaseClass {
	
	@Test(priority=1)
	public void PageEntryOperation() {
		AccountaddPage addacc=new AccountaddPage(driver);
		addacc.SelectCountry();
		
	}
	
	@Test(priority=2)
	public void AccountaddOperation() {
		AccountaddPage addacc=new AccountaddPage(driver);
		addacc.AccountLink();		
		addacc.CreateAccountLink();
		addacc.EnterFirstName(prop.getProperty("Firstname"));
		addacc.EnterLastName(prop.getProperty("Lastname"));
		addacc.EnterEmailId(prop.getProperty("Emailid"));
		addacc.EnterPassword(prop.getProperty("Password"));
		addacc.EnterConfirmPwd(prop.getProperty("ConfirmPwd"));
		addacc.EnterMobileNo(prop.getProperty("MobileNo"));
		addacc.CreateAccBtn();
}
}
