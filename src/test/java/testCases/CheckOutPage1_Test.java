package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.CheckOutPage1;
import pages.Inventory_page_2;
import pages.LoginPage;

public class CheckOutPage1_Test extends TestBase
{
	LoginPage login;
	Inventory_page_2 invent;
	Cart_Page cart;
	CheckOutPage1 check1;
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_page_2(); 
		cart=new Cart_Page();
		check1=new CheckOutPage1();
		login.loginToApplication(); 
		invent.add6Products();
		invent.ClickcartCount();
		cart.clickOnCkeckOutBtn();
	}
	@Test
	public void  verifyURLOfCheckOutPage1Test()
	{
		String expURL="https://www.saucedemo.com/checkout-step-one.html";
		String actURL=check1.verifyURLOfCheckOutPage1();
		Assert.assertEquals(expURL,actURL);
		Reporter.log(" URL of chcekout page 1 = " +actURL);
	}
	@Test
	public void verifyTitleofApplicationTest()
	{
		String expTitle="Checkout: Your Information";
		String actTitle=check1.verifyTitleofApplication();
		Assert.assertEquals(expTitle,actTitle);
		Reporter.log("Title of check out page 1 = " + actTitle);
	}
	@Test
	public void InputinformationTest()
	{
		String expURL="https://www.saucedemo.com/checkout-step-two.html"; 
		String actURL=check1.Inputinformation();
		Assert.assertEquals(expURL,actURL); 
		Reporter.log(" Title of check out page 2 = " +actURL);
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	
}
