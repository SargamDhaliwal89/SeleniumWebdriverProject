package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonutil.BaseClass;


public class HomePage{
	public BaseClass base;

	public WebDriver driver;
	public WebElement inputform;

	public HomePage(WebDriver driver) //this will initialize the webdriver
	{
		this.driver=driver;
		base = new BaseClass(driver);
	}

	public void click_on_dropdown(By loc) {
		inputform = driver.findElement(loc);
		inputform.click();
	}

	public void displaydropdownvalues(int r, int c, int rr) {
		
		base.waitForElementToBeClickable(By.xpath(".//*[@id='navbar-brand-centered']/ul["+r+"]/li["+c+"]/a"));
		base.click(By.xpath(".//*[@id='navbar-brand-centered']/ul["+r+"]/li["+c+"]/a"));
	
		base.
		getDropdownValues(By.xpath(".//*[@id='navbar-brand-centered']/ul["+r+"]/li["+c+"]/ul["+rr+"]"),
				By.xpath(".//*[@id='navbar-brand-centered']/ul["+r+"]/li["+c+"]/ul["+rr+"]/li"));
	}
}
