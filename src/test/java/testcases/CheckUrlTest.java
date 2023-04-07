package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.AccountaddPage;
import pageObjects.CheckUrlPage;

public class CheckUrlTest  extends BaseClass {

	@Test(priority=1)
	public void PageEntryOperation(){
		AccountaddPage addacc=new AccountaddPage(driver);
		addacc.SelectCountry();
		
	}
	@Test(priority=2)
	public void BrokenURLOperation(){
		CheckUrlPage urlchk=new CheckUrlPage(driver);
		urlchk.BrokenUrl();
	}
	
}
