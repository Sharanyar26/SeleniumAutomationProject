package PageObects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//a[@href='/products']") WebElement clickHere;
	@FindBy(xpath="//a[@class='btn btn-default check_out']") WebElement proceedToCheckout;
	@FindBy(xpath="//a[@class='btn btn-default check_out']") WebElement placeOrder;
	@FindBy(xpath="//input[@name='name_on_card']")WebElement nameOnCard;
	@FindBy(xpath="//input[@name='card_number']")WebElement  cardNumber;
	@FindBy(xpath="//input[@placeholder='ex. 311']")WebElement cvc;
	@FindBy(xpath="//input[@placeholder='MM']")WebElement month;
	@FindBy(xpath="//input[@placeholder='YYYY']")WebElement year;	
	@FindBy(xpath="//button[@id='submit']")WebElement payAndConfirm;
	@FindBy(xpath="//a[@href='/payment']")WebElement gotoPayment;
	@FindBy(xpath="//p[contains(text(),'Congratulations! Your order has been confirmed!')]") WebElement confirmationMsg;
	//@FindBy(xpath="");	@FindBy(xpath="");	@FindBy(xpath="");
	
	public void confirmOrder() 
	{
		placeOrder.click();
	}
	
	public void enterPaymentInfo(String name, String cardNo, String cvv, String mm, String yyyy)
	{
	    nameOnCard.sendKeys(name);
	    cardNumber.sendKeys(cardNo);
	    cvc.sendKeys(cvv);
	    month.sendKeys(mm);
	    year.sendKeys(yyyy);
	}
	
	public void pay() 
	{
		payAndConfirm.click();
		
	}
	public void gotoPay()
	{
		gotoPayment.click();
	}
	public boolean isOrderConfirmed() {
	    return confirmationMsg.isDisplayed();
	}

	public String getConfirmationText() {
	    return confirmationMsg.getText();
	}


}
