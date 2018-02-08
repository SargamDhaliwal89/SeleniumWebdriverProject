package testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import commonutil.BaseClass;
import commonutil.OpenandCloseBrowser;
import pageObject.HomePage;
import pageObject.HomePageElements;

public class HomepageTest extends OpenandCloseBrowser  {

	List<WebElement> rows;
	List<WebElement> columns;
	List<String> elementList;

	BaseClass base;
	HomePage home;
	HomePageElements getelement;
	String expected_title = "Selenium Easy - Best Demo website to practice Selenium Webdriver Online";
	String expected_url = "http://www.seleniumeasy.com/test/";
	String expectedcarousel_secondheading = "START WRITING YOUR SELENIUM SCRIPTS WITH MOST POPULAR FRONTEND FRAMEWORK";
	String expectedcarousel_firstheading = "BECOMING AN EXPERT WILL BE FUN AND EXCITING.";

	/**********TestCases************/
	@Test(enabled=true, priority=1)
	public void verifyPageTitle()	{
		//logger=report.startTest("verifyPageTitle()");
		
		logger.log(LogStatus.INFO, "We are going to verify the page title");
		
		base = new BaseClass(driver);
		
		base.waitForElementToBeClickable(HomePageElements.getnavbar_demolink);
		
		//base.click(HomePageElements.getnavbar_demolink);
		
		logger.log(LogStatus.INFO, "We have clicked on demo link visible in the mid of nav bar ");
		
		Assert.assertEquals(base.getPageTitle(),expected_title );
		
		logger.log(LogStatus.PASS, "page title is verified");
	}
	
	@Test(enabled=true, priority=2)
	public void verifyCurrentURL() {
		
		base = new BaseClass(driver);
		
		base.waitForElementToBeClickable(HomePageElements.getnavbar_demolink);
	
		//base.click(HomePageElements.getnavbar_demolink);
		
		Assert.assertEquals(base.getCurrentPageUrl(),expected_url );
		
		logger.log(LogStatus.PASS, "page URL is verified");
	}
	
	@Test(enabled=true, priority=3)
	public void verifyInputFormDropdown(){
		
		base = new BaseClass(driver);
		
		home = new HomePage(driver);
		
		home.displaydropdownvalues(1, 1, 1);
		
		logger.log(LogStatus.PASS, "First dropdown of left nav bar is verified");
		//		home.click_on_dropdown(HomePageElements.getinputformdropdown);
		//		base.getDropdownValues(HomePageElements.getinputform_row, HomePageElements.getinputform_column);

	}
	
	@Test(enabled=true, priority=4)
	public void verifyDatePickerDropdown(){
		
		base = new BaseClass(driver);
		
		home = new HomePage(driver);
		
		base.getcookies();
		
		home.displaydropdownvalues(1, 2, 1);
		
		logger.log(LogStatus.PASS, "Second dropdown of left nav bar is verified");
		//		home.click_on_dropdown(HomePageElements.getdatepickerdropdown);
		//		base.getDropdownValues(HomePageElements.getdatepicker_row, HomePageElements.getdatepicker_column);
	}
	@Test(enabled=false)
	public void verifyTableDropdown(){
		base = new BaseClass(driver);
		home = new HomePage(driver);
		home.displaydropdownvalues(1, 3, 1);
		//		home.click_on_dropdown(HomePageElements.gettabledropdown);
		//		base.getDropdownValues(HomePageElements.gettable_row, HomePageElements.gettable_column);
	}
	@Test(enabled=false)
	public void verifyProgressBarsDropdown(){
		base = new BaseClass(driver);
		home = new HomePage(driver);
		home.displaydropdownvalues(2, 1, 1);
		//		home.click_on_dropdown(HomePageElements.getprogressbarsdropdown);
		//		base.getDropdownValues(HomePageElements.getprogressbars_row, HomePageElements.getprogressbars_column);
	}
	@Test(enabled=false)
	public void verifyAlertAndModalsDropdown(){
		base = new BaseClass(driver);
		home = new HomePage(driver);
		home.displaydropdownvalues(2, 2, 1);
		//		home.click_on_dropdown(HomePageElements.getalertandmodalsdropdown);
		//		base.getDropdownValues(HomePageElements.getalertandmodals_row, HomePageElements.getalertandmodals_column);
	}
	@Test(enabled=false)
	public void verifyListBoxDropdown(){
		base = new BaseClass(driver);
		home = new HomePage(driver);
		home.displaydropdownvalues(2, 3, 1);
		//		home.click_on_dropdown(HomePageElements.getlistboxdropdown);
		//		base.getDropdownValues(HomePageElements.getlistbox_row, HomePageElements.getlistbox_column);
	}
	@Test(enabled=false)
	public void verifyOthersDropdown(){
		base = new BaseClass(driver);
		home = new HomePage(driver);
		home.displaydropdownvalues(2, 4, 1);
		//		home.click_on_dropdown(HomePageElements.getothersdropdown);
		//		base.getDropdownValues(HomePageElements.getothers_row, HomePageElements.getothers_column);
	}
	@Test(enabled=false)
	public void verifyRightCarouselArrow() {
		base = new BaseClass(driver);
		base.click(HomePageElements.getright_carousel);
		base.sleep(5000);
		List<WebElement> links = driver.findElements(HomePageElements.getbyheadinglinks);
		for(WebElement ele:links){
			String str = ele.getText();
			if(str.equalsIgnoreCase(expectedcarousel_secondheading)) {
				Assert.assertEquals(str, expectedcarousel_secondheading);
				System.out.println(str);
			}
		}
	}
	@Test (enabled=false)
	public void verifyLeftCarouselArrow() {
		base = new BaseClass(driver);
		base.click(HomePageElements.getleft_carousel);
		base.sleep(5000);
		List<WebElement> links = driver.findElements(HomePageElements.getbyheadinglinks);
		for(WebElement ele:links){
			String str = ele.getText();
			if(str.equalsIgnoreCase(expectedcarousel_firstheading)) {
				Assert.assertEquals(str, expectedcarousel_firstheading);
				System.out.println(str);
			}
		}
	}
	@Test (enabled=false)
	public void verifyCollapseOfAllExamplesTreeView() {
		base = new BaseClass(driver);
		base.scrollToThenClick(HomePageElements.getparentnode);
		List<WebElement> subtree = driver.findElements(HomePageElements.getsubtreenodes); 
		for(WebElement childnode: subtree) {
			if(childnode.getText()==null){
				System.out.println(childnode.getText());
			}
		}
		base.sleep(5000);
	}
	@Test (enabled=false)
	public void verifyExpandOfAllExamplesTreeView() {
		base = new BaseClass(driver);
		base.scrollToThenClick(HomePageElements.getparentnode);
		base.click(HomePageElements.getparentnode);
		List<WebElement> subtree = driver.findElements(HomePageElements.getsubtreenodes); 
		for(WebElement childnode: subtree) {
			if(childnode!=null){
				System.out.println("Tree contains:"+childnode.getText());
			}
		}
		base.sleep(5000);
	}
	@Test(enabled=false)
	public void verifyHomeToolTipMsg() {
		base = new BaseClass(driver);
		base.scrollToThenClick(HomePageElements.gethomebar);
		String msg=base.moveCoursorToToolTipAndGetItsMsg(HomePageElements.gettooltip);
		System.out.println(msg);
	}
	@Test(enabled=false)
	public void verifyBasicToolTipMsg() {
		base = new BaseClass(driver);
		base.scrollToThenClick(HomePageElements.gethomebar);
		base.click(HomePageElements.getbasicexample);
		String msg=base.moveCoursorToToolTipAndGetItsMsg(HomePageElements.getbasicexampletooltip);
		System.out.println(msg);
	}
	@Test(enabled=false)
	public void verifyIntermediateToolTipMsg() {
		base = new BaseClass(driver);
		base.scrollToThenClick(HomePageElements.gethomebar);
		base.click(HomePageElements.getintermediate);
		String msg=base.moveCoursorToToolTipAndGetItsMsg(HomePageElements.getintermediatetooltip);
		System.out.println(msg);
	}
	@Test(enabled=false)
	public void verifyAdvancedToolTipMsg() {
		base = new BaseClass(driver);
		base.scrollToThenClick(HomePageElements.gethomebar);
		base.click(HomePageElements.getadvanced);
		String msg=base.moveCoursorToToolTipAndGetItsMsg(HomePageElements.getadvancedtooltip);
		System.out.println(msg);
	}
	@Test(enabled=false)
	public void verifyCompletedToolTipMsg() {
		base = new BaseClass(driver);
		base.scrollToThenClick(HomePageElements.gethomebar);
		driver.navigate().refresh();
		base.click(HomePageElements.getcompleted);
		String msg=base.moveCoursorToToolTipAndGetItsMsg(HomePageElements.getcompletedtooltip);
		System.out.println(msg);
	}
	@Test (enabled=false)
	public void verifyFooterTutorialMenu() {
		base = new BaseClass(driver);
		base.scrollToThenClick(HomePageElements.gettutorialsmenuitem);
		List<WebElement> menuitems = driver.findElements(HomePageElements.gettutorialsmenuitem); 
		for(WebElement item: menuitems) {
			System.out.println(item.getText());
		}
	}
	@Test (enabled=false)
	public void verifyFooterPopularPost() {
		base = new BaseClass(driver);
		base.scrollToThenClick(HomePageElements.gettutorialsmenuitem);
		List<WebElement> menuitems = driver.findElements(HomePageElements.getpopularpostitem); 
		for(WebElement item: menuitems) {
			System.out.println(item.getText());
		}
	}
	@Test (enabled=false)
	public void verifyWelcomeContentBox() {
		base = new BaseClass(driver);
		base.scrollToThenClick(HomePageElements.gethomebar);
		List<WebElement> boxitems = driver.findElements(HomePageElements.getwelcomecontentbox); 
		for(WebElement item: boxitems) {

			Assert.assertTrue(item.getText().contains("WELCOME TO SELENIUM EASY DEMO"));
		}
	}
	@Test(enabled=false)
	public void verifyBasicContentBox() {
		base = new BaseClass(driver);
		base.scrollToThenClick(HomePageElements.gethomebar);
		base.click(HomePageElements.getbasicexample);
		base.sleep(3000);
		List<WebElement> boxitems = driver.findElements(HomePageElements.getbasiccontentbox); 
		for(WebElement item: boxitems) {
			Assert.assertTrue(item.getText().contains("BASIC EXAMPLES TO START WITH SELENIUM"));
		}
	}
	@Test(enabled=false)
	public void verifyIntermediateContentBox() {
		base = new BaseClass(driver);
		base.scrollToThenClick(HomePageElements.gethomebar);
		base.click(HomePageElements.getintermediate);
		base.sleep(3000);
		List<WebElement> boxitems = driver.findElements(HomePageElements.getintermediatecontentbox); 
		for(WebElement item: boxitems) {
			Assert.assertTrue(item.getText().contains("INTERMEDIATE EXAMPLES WITH MOST POPULAR COMPONENTS"));
		}
	}
	@Test(enabled=false)
	public void verifyAdvancedContentBox() {
		base = new BaseClass(driver);
		base.scrollToThenClick(HomePageElements.gethomebar);
		base.click(HomePageElements.getadvanced);
		base.sleep(3000);
		List<WebElement> boxitems = driver.findElements(HomePageElements.getadvancedcontentbox); 
		for(WebElement item: boxitems) {
			Assert.assertTrue(item.getText().contains("ADVANCED EXAMPLES WITH COMPONENTS"));
		}
	}
	@Test
	public void verifyCompletedContentBox() {
		base = new BaseClass(driver);
		base.scrollToThenClick(HomePageElements.gethomebar);
		base.click(HomePageElements.getcompleted);
		base.sleep(3000);
		List<WebElement> boxitems = driver.findElements(HomePageElements.getcompletedcontentbox); 
		for(WebElement item: boxitems) {
			Assert.assertTrue(item.getText().contains("THANKS FOR STAYING TUNED! WE ARE DONE"));
		}
	}

}
