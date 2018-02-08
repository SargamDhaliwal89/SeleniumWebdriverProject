package commonutil;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;
import org.testng.annotations.Parameters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils; 

public class BaseClass {
	protected WebDriver driver;
	public Actions actions;

	WebDriverWait wait;
	public String current_url;
	public String title;

	long Longtime=30;
	long shortTime=20;


	public BaseClass(WebDriver driver){  //constructor
		this.driver=driver;

		wait=new WebDriverWait(driver,shortTime);
	}

	/**
	 * This will return a string containing page title
	 * */
	public String getPageTitle() {  
		try {  
			return driver.getTitle();  
		} 

		catch (Exception e) {  
			throw new TestException(String.format("Current page title is: %s", driver.getTitle()));  
		}  
	}  

	/**
	 * This will return a current URL
	 * */
	public String getCurrentPageUrl(){

		try {  
			return driver.getCurrentUrl();  
		} 

		catch (Exception e) {  
			throw new TestException(String.format("Current URL is: %s", driver.getCurrentUrl()));  
		}  
	}

	public WebElement getElement(By selector) {  
		try {  
			return driver.findElement(selector);  
		} 

		catch (Exception e) {  
			System.out.println(String.format("Element %s does not exist - proceeding", selector));  
		}  
		return null;  
	}  

	public String getElementText(By selector) {  
		waitUntilElementIsDisplayedOnScreen(selector);  

		try {  
			return StringUtils.trim(driver.findElement(selector).getText());  
		} 

		catch (Exception e) {  
			System.out.println(String.format("Element %s does not exist - proceeding", selector));  
		}  
		return null;  
	} 

	public void clearField(WebElement element) {  
		try {  
			element.clear();  
		} catch (Exception e) {  
			System.out.print(String.format("The following element could not be cleared: [%s]", element.getText()));  
		}  
	}  

	public void sendKeys(By selector, String value) {  
		WebElement element = getElement(selector);  
		clearField(element);  
		try {  
			element.sendKeys(value);  
		} catch (Exception e) {  
			throw new TestException(String.format("Error in sending [%s] to the following element: [%s]", value, selector.toString()));  
		}  
	}  

	public void click(By selector){
		waitForElementToDisplay(selector);
		WebElement element=driver.findElement(selector);

		try {  
			element.click();
		}
		catch (Exception e) {  
			throw new TestException(String.format("The following element is not clickable: [%s]", selector)); 
		}
	}

	public void scrollToThenClick(By selector) {  
		WebElement element = driver.findElement(selector);  
		actions = new Actions(driver);  
		try {  
			((JavascriptExecutor) driver).
			executeScript("arguments[0].scrollIntoView(true);", element);  

			actions.moveToElement(element).perform();  
			actions.click(element).perform();  
		} 
		catch (Exception e) {  
			throw new TestException(String.format("The following element is not clickable: [%s]", element.toString()));  
		}  
	} 

	public String moveCoursorToToolTipAndGetItsMsg(By Selector) {
		actions = new Actions(driver); 
		WebElement tooltip=driver.findElement(Selector);
		actions.moveToElement(tooltip).perform();
		String tooltip_msg=tooltip.getText();
		return tooltip_msg;
	}

	/**
	 * This function will wait till element is not visible 
	 */
	public void waitUntilElementIsDisplayedOnScreen(By selector) {  

		try {  
			wait = new WebDriverWait(driver, Longtime);  
			wait.until(ExpectedConditions.visibilityOfElementLocated(selector));  
		} 

		catch (Exception e) {  
			throw new NoSuchElementException(String.format("The following element was not visible: %s ", selector));  
		}  
	}  
	public void waitForElementToBeClickable(By selector) {  

		try {  
			wait = new WebDriverWait(driver, Longtime);  
			wait.until(ExpectedConditions.elementToBeClickable(selector));  
		} 

		catch (Exception e) {  
			throw new TestException("The following element is not clickable: " + selector);  
		}  
	}  

	public void navigateToURL(String URL) {  

		try {  
			driver.navigate().to(URL);  
		} 

		catch (Exception e) {  
			System.out.println("FAILURE: URL did not load: " + URL);  

			throw new TestException("URL did not load");  
		}  
	}  

	public void navigateBack() {  
		try {  
			driver.navigate().back();  
		} 
		catch (Exception e) {  
			System.out.println("FAILURE: Could not navigate back to previous page.");  

			throw new TestException("Could not navigate back to previous page.");  
		}  
	} 

	public void sleep(final long millis) {  
		System.out.println((String.format("sleeping %d ms", millis)));  
		try {  
			Thread.sleep(millis);  
		} 

		catch (InterruptedException ex) {  
			ex.printStackTrace();  
		}  
	}  

	public void waitForElementToDisplay(By Selector) {  
		WebElement element = getElement(Selector);  

		while (!element.isDisplayed()) {  
			System.out.println("Waiting for element to display: " + Selector);  
			sleep(200);  
		}  
	}  

	public List<String> getDropdownlist(By selector) {  
		waitForElementToDisplay(selector);  
		Select dropdown = new Select(getElement(selector));  
		List<String> elementList = new ArrayList<String>();  
		List<WebElement> allValues = dropdown.getOptions();  

		if (allValues == null) {  
			throw new TestException("Some elements in the list do not exist");  
		}  

		for (WebElement value : allValues) {  
			if (value.isDisplayed()) {  
				elementList.add(value.getText().trim());  
			}  
		}  
		return elementList;  
	}

	@SuppressWarnings("unused")
	public List<String> getDropdownValues(By selector_row, By selector_col) {  
		waitForElementToDisplay(selector_row);  
		List<WebElement> rows = driver.findElements(selector_row); 
		List<String> elementList = new ArrayList<String>();  
		List<WebElement> columns ;

		if (rows == null) {  
			throw new TestException("Some elements in the list do not exist");  
		}  

		for(WebElement value: rows)
		{
			columns =driver.findElements(selector_col);

			for (WebElement col : columns) {  
				if (col.isDisplayed()) {  
					elementList.add(col.getText().trim());  
				}  
			}  
			System.out.println(elementList);
		}
		return elementList;
	}

	
	@SuppressWarnings("resource")
	public void getcookies () {
		try{

			File file = new File(System.getProperty("user.dir")+"/Cookie.data");

			FileReader fileReader = new FileReader(file);

			BufferedReader Buffreader = new BufferedReader(fileReader);

			String strline;

			while((strline=Buffreader.readLine())!=null){

				StringTokenizer token = new StringTokenizer(strline,";");

				while(token.hasMoreTokens()){

					String name = token.nextToken();String value = token.nextToken();

					String domain = token.nextToken();String path = token.nextToken();

					SimpleDateFormat d;
				       
					Date expiry = null;

					String val;

					if(!(val=token.nextToken()).equals("null")){
						d = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
						expiry = d.parse(val);				
						//System.out.println(expiry);
					}

					Boolean isSecure = new Boolean(token.nextToken()).booleanValue();

					Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);

					driver.manage().addCookie(ck); // This will add the stored cookie to our current session
				}
				driver.navigate().refresh();
			}

		}catch(Exception ex){

			ex.printStackTrace();

		}
	}


}
