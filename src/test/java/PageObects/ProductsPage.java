package PageObects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

	 public ProductsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[@href='/product_details/1']")WebElement firstProduct;
	@FindBy(xpath="//button[@type='button']") WebElement addToCartFirst;
	@FindBy(xpath="//button[@class='btn btn-default cart']") WebElement addToCartBtn;
	@FindBy(xpath="//a[@href='/view_cart']")WebElement viewcartInNewPopUp;
	public void addToCart()
	{
		addToCartBtn.click();
	}
	public void viewFirstProduct()
	{
		 firstProduct.click();
	}
	public void addToCart1() {
		addToCartFirst.click();
	}
	public void hoverOnFirstProduct()
	{
		Actions act=new Actions(driver);
		act.moveToElement(firstProduct).build().perform();
	}
	public void viewCart()
	{
		viewcartInNewPopUp.click();
	}

}
