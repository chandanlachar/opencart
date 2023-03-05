package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends BasePage{

	public Loginpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="email")  WebElement txt_email;
	@FindBy(name="password")  WebElement txt_password;
	@FindBy(xpath="//button[@class='btn btn-primary btn-lg hidden-xs']")  WebElement btn_login;
	
	public void setemail(String email) {
		txt_email.sendKeys(email);
	}
	public void setpassword(String password ) {
		txt_password.sendKeys(password);
	}
	public void clicklogin() {
		btn_login.click();
		
	}
	

}
