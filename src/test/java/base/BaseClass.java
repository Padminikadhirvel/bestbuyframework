package base;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import pageObjects.AccountaddPage;
import utilities.Utility;

public class BaseClass extends Utility{
	@BeforeClass
	  public void Startup() throws IOException {
		  driver=initializeDriver();
		  driver.get(prop.getProperty("url"));
	  }

	  @AfterClass
	  public void close() {
//		  driver.quit();
	  }

}