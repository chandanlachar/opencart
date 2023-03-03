package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
//constructor
	public RegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	//webelements
	@FindBy (id="input-firstname") WebElement txt_firstname;
	@FindBy (name="lastname") WebElement txt_lastname ;
	@FindBy (name="email") WebElement txt_email ;
	@FindBy (name="password") WebElement txt_password;
	@FindBy (name="agree") WebElement ck_agree;
    @FindBy (xpath="//button[normalize-space()='Continue']") WebElement Btn_click;
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")  WebElement msgConfirmation;
    
   //Actions
    public void setfirestname(String firstname) {
    	txt_firstname.sendKeys(firstname);
    	
    }
    public void setlastname(String lastname) {
    	txt_lastname.sendKeys(lastname);
    }
    public void setemail(String email) {
    	txt_email.sendKeys(email);
    }
    public void setpassword(String password) {
    	txt_password.sendKeys(password);
    }
    public void clickagree() {
    	ck_agree.click();
    }
    public void clickclick() {
    	Btn_click.click();
    }
    	public String getConfirmationMsg() {
			try {
				return (msgConfirmation.getText());
			} catch (Exception e) {
				return (e.getMessage());

			}

    }
}
