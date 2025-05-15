package PageObects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//input[@type='email']")WebElement email;
	@FindBy(xpath="//input[@type='password']")WebElement password;
	@FindBy(xpath="//button[@type='submit']")WebElement submitbtn;
	
	
	public void loginDetails(String emailId,String pswd)
	{
		email.sendKeys(emailId);
		password.sendKeys(pswd);
	}
	
	public void submit() 
	{
		submitbtn.click();
	}
	

}
