package testCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObject.HomePage;
import pageObject.RegistrationPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	@Test
	public void testaccresgitration() {
		try {
		 HomePage h=new HomePage(driver);
		 logger.info("Click on myaccount in home page");
		   h.clickMyAccount();
		   logger.info("click on register");
		   h.clickRegistration();
		   
		 RegistrationPage p=new RegistrationPage(driver);  
		 logger.info("Welcome to reg page and set firstname");
		 p.setfirestname(randomString());
		 logger.info("set last name");
		 p.setlastname(randomString());
		 logger.info("setting gmail");
		 p.setemail(randomString()+"@gmail.com");  //randomly
		 //ponebumber p.sethonenmer(randomNumber ());
		 logger.info("setting password");
		 p.setpassword(randomAlpaNumericsp());
		 p.clickagree();
		 p.clickclick();
		 logger.info("validating expected message");
		 String confmsg=p.getConfirmationMsg();
			
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");

		
		}
		catch(Exception e) {
			Assert.fail();
		}
	}
       
}
