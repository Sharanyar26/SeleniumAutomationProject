package PageObects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[normalize-space()='Home']") WebElement home;
	@FindBy(xpath="//a[@href='/products']") WebElement Products;
	@FindBy(xpath="//a[normalize-space()='Cart']") WebElement cart;
	
	
	@FindBy(xpath="//a[@href='/login']") WebElement login;
	@FindBy(xpath="//a[@href='/logout']") WebElement logout;
	@FindBy(xpath="//a[@href='/delete_account']") WebElement deleteAcc;
	
	@FindBy(xpath="//a[@href='#Women']") WebElement women;
	@FindBy(xpath="//a[@href='#Men']") WebElement men;
	@FindBy(xpath="//a[@href='#Kids']")WebElement kids;
	
	
	@FindBy(xpath="")WebElement bluetop;
	@FindBy(xpath="//a[@href='/view_cart']") WebElement viewCart;
	@FindBy(xpath="//div[@class='item active']//div[1]//div[1]//div[1]//div[1]//a[1]")WebElement addToCart;
	
	
	public void logout() 
	{
		logout.click();
	}
	
	public void addToCart()
	{
		addToCart.click();
	}
	
	public void womenbtn()
	{
		women.click();
	}
	
	public void menbtn()
	{
		men.click();
	}
	
	public void kidsbtn()
	{
		kids.click();
	}
	public void productsbtn() {
		Products.click();
	}
	
	public void gotoCart()
	{
		cart.click();
	}
	
	public void clickLogin() 
	 {
		 login.click();
	 }
	

}
