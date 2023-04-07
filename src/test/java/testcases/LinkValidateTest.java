package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.AccountaddPage;
import pageObjects.LinkValidatePage;

public class LinkValidateTest extends BaseClass{
	
	@Test(priority=1)
	public void PageEntryOperation() {
		AccountaddPage addacc=new AccountaddPage(driver);
		addacc.SelectCountry();
		
	}
	
	@Test(priority=2)
	public void ValidateBottomLinkofHomePage()
	{
		LinkValidatePage chk=new LinkValidatePage(driver);
		chk.ValidateLinks();
	}


}
