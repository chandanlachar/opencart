package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	//calling Basepage constructor
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement  dd_myaccount;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement dd_register;
	@FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Login']") WebElement dd_login;
	
	public void clickMyAccount() {
		dd_myaccount.click();
	}
	public void clickRegistration() {
		dd_register.click();
	}
	public void ClickLogin() {
		dd_login.click();
	}
}

