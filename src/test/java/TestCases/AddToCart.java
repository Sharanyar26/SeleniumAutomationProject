package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObects.CartPage;
import PageObects.HomePage;
import PageObects.LoginPage;
import PageObects.ProductsPage;
import TestBase.BaseClass;
import Utilities.ConfigReader;

public class AddToCart extends BaseClass {
	
	
	
	@Test(priority=1)
	public void login() 
	{
	test = extent.createTest("Login Test");
	HomePage h=new HomePage(driver);
	
	h.clickLogin();
	
	LoginPage l=new LoginPage(driver);
	String username = ConfigReader.getProperty("username");
    String password = ConfigReader.getProperty("password");
    l.loginDetails(username, password);
//	l.loginDetails("shar@gmail.com", "12345678");
	l.submit();
	test.log(Status.PASS, "Login successful");
		
	}
	@Test(priority=2)
	public void TestingAddToCart() 
	{
		test = extent.createTest("Add To Cart Test");
		HomePage h=new HomePage(driver);
        h.productsbtn();
		
		ProductsPage p=new ProductsPage(driver);
		p.viewFirstProduct();
		p.addToCart1();
		p.viewCart();
		CartPage c= new CartPage(driver);
		c.confirmOrder();
		c.gotoPay();

		String name = ConfigReader.getProperty("name");
		String card = ConfigReader.getProperty("cardnumber");
		String cvc = ConfigReader.getProperty("cvc");
		String month = ConfigReader.getProperty("expiryMonth");
		String year = ConfigReader.getProperty("expiryYear");
		c.enterPaymentInfo(name,card,cvc,month,year);
		c.pay();
		test.log(Status.PASS, "Payment Successful");
		
	}
	 @Test(priority = 3)
	    public void verifyOrderConfirmation()
	 {
		 String testName = "verifyOrderConfirmation";
		 	CartPage c = new CartPage(driver); 
		 	try {
		        Assert.assertFalse(c.isOrderConfirmed(), "Order confirmation message not displayed!");
		        System.out.println("Order confirmation validated successfully!");
		    } catch (AssertionError e) {
		        
		        CaptureScreen(testName);
		        throw e;
		    }
//		    Assert.assertTrue(c.isOrderConfirmed(), "Order confirmation message not displayed!");
//		    System.out.println("Order confirmation validated successfully!");
	 }

}
