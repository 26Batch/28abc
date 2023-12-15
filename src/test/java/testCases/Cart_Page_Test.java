package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.Inventory_page_2;
import pages.LoginPage;
import utility.ReadData;

public class Cart_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_page_2 invent;
	Cart_Page cart;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_page_2(); 
		cart=new Cart_Page();
		login.loginToApplication(); 
		invent.add6Products();
		invent.ClickcartCount();
	} 
	@Test
	public void verifyURLOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,8);//https://www.saucedemo.com/cart.html
		String actURL=cart.verifyCartPageURL();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("URL of cart page = "+actURL);
	}
	@Test
	public void verifyTitleCartPageTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(0,9);//Your Cart
		String actTitle=cart.verifyCartLable();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Title of Crat page"+actTitle);
	}
	
	@AfterMethod (alwaysRun = true)
	public void closeBrowser()
	{
		driver.close();
	}
	
}
