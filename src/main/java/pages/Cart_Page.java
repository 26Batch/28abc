package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Cart_Page extends TestBase
{
	@FindBy(xpath="//span[text()='Your Cart']") private WebElement lable;
	@FindBy(xpath=("//button[@name='checkout']")) private WebElement checkOutBtn;
	public Cart_Page()
	{
		PageFactory.initElements(driver,this);
	} 
	public String verifyCartPageURL()
	{
		return driver.getCurrentUrl();
	}
	public String verifyCartLable()
	{
		return lable.getText();
	}
	public void clickOnCkeckOutBtn()
	{
		checkOutBtn.click();
	}

}
