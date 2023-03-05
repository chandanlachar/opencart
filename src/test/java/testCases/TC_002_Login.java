package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.Loginpage;
import pageObject.MyAccountPage;
import testBase.BaseClass;


public class TC_002_Login extends BaseClass{
	
	@Test(groups= {"sanity","master"})
	public void Login() {
		try {
			logger.info("Begining of login");
			HomePage h=new HomePage(driver);
			h.clickMyAccount();
			logger.info("clicked on my account");
			h.ClickLogin();
			logger.info("clicked on login");
			
		Loginpage l=new Loginpage(driver);
		l.setemail(rb.getString("email"));
		logger.info("email is set");
		l.setpassword(rb.getString("password"));
		logger.info("password is set");
		l.clicklogin();
		
		MyAccountPage m=new MyAccountPage(driver);
		boolean targetpage=m.isMyAccountPageExists();
		Assert.assertEquals(targetpage,true);
		}
		catch(Exception e) {
			Assert.fail();
			logger.info("FINISHED");
		}
	}
		
}
