package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.CheckOutCompletePage;
import pages.CheckOutPage1;
import pages.CheckOutPage2;
import pages.Inventory_page_2;
import pages.LoginPage;

public class CheckOutCompleteTest extends TestBase
{
	LoginPage login;
	Inventory_page_2 invent;
	Cart_Page cart;
	CheckOutPage1 check1;
	CheckOutPage2 check2;
	CheckOutCompletePage complete;
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_page_2(); 
		cart=new Cart_Page();
		check1=new CheckOutPage1();
		check2=new CheckOutPage2();
		complete=new CheckOutCompletePage();
		login.loginToApplication(); 
		invent.add6Products();
		//invent.ClickcartCount();
		cart.clickOnCkeckOutBtn();
		check1.Inputinformation();
		check2.clickOnFinishBtn();
	}
	@Test
	public void verifyURLTest()
	{
		String expURL="https://www.saucedemo.com/checkout-complete.html";
		String actURL=complete.verifyURL();
		Assert.assertEquals(expURL,actURL); 
		Reporter.log("URL of check out complete page = " + actURL);
	}
	@Test
	public void verifyImgTest()
	{
		boolean result=complete.verifyImg();
		Assert.assertEquals(result,true);
		Reporter.log("Visibility of Pony Logo = " + result);
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}




}
