package pageObject;

import org.openqa.selenium.By;

public class HomePageElements {
	//left nav bar
	private static String inputformdropdown = "//*[@id='navbar-brand-centered']/ul/li[1]/a";
	private static String datepickerdropdown = ".//*[@id='navbar-brand-centered']/ul/li[2]/a";
	private static String tabledropdown =".//*[@id='navbar-brand-centered']/ul/li[3]/a";

	private static String inputform_row = ".//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul";
	private static String inputform_column = ".//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul[1]/li";
	private static String datepicker_row =".//*[@id='navbar-brand-centered']/ul[1]/li[2]/ul";
	private static String datepicker_column =".//*[@id='navbar-brand-centered']/ul[1]/li[2]/ul[1]/li";
	private static String table_row =".//*[@id='navbar-brand-centered']/ul[1]/li[3]/ul";
	private static String table_column =".//*[@id='navbar-brand-centered']/ul[1]/li[3]/ul[1]/li";

	public static By getinputformdropdown=By.xpath(inputformdropdown);
	public static By getdatepickerdropdown=By.xpath(datepickerdropdown);
	public static By gettabledropdown=By.xpath(tabledropdown);
	public static By getinputform_row =By.xpath(inputform_row);
	public static By getinputform_column =By.xpath(inputform_column);
	public static By getdatepicker_row =By.xpath(datepicker_row);
	public static By getdatepicker_column =By.xpath(datepicker_column);
	public static By gettable_row =By.xpath(table_row);
	public static By gettable_column =By.xpath(table_column);


	//right nav bar	
	private static String progressbarsdropdown = ".//*[@id='navbar-brand-centered']/ul[2]/li[1]/a";
	private static String alertandmodalsdropdown =".//*[@id='navbar-brand-centered']/ul[2]/li[2]/a";
	private static String listboxdropdown = ".//*[@id='navbar-brand-centered']/ul[2]/li[3]/a";
	private static String othersdropdown = ".//*[@id='navbar-brand-centered']/ul[2]/li[4]/a";

	private static String progressbars_row = ".//*[@id='navbar-brand-centered']/ul[2]/li[1]/ul";
	private static String progressbars_column = ".//*[@id='navbar-brand-centered']/ul[2]/li[1]/ul[1]/li";
	private static String alertandmodals_row = ".//*[@id='navbar-brand-centered']/ul[2]/li[2]/ul";
	private static String alertandmodals_column = ".//*[@id='navbar-brand-centered']/ul[2]/li[2]/ul[1]/li";
	private static String listbox_row = ".//*[@id='navbar-brand-centered']/ul[2]/li[3]/ul";
	private static String listbox_column = ".//*[@id='navbar-brand-centered']/ul[2]/li[3]/ul[1]/li";
	private static String others_row = ".//*[@id='navbar-brand-centered']/ul[2]/li[4]/ul";
	private static String others_column = ".//*[@id='navbar-brand-centered']/ul[2]/li[4]/ul[1]/li";

	public static By getprogressbarsdropdown=By.xpath(progressbarsdropdown);
	public static By getalertandmodalsdropdown=By.xpath(alertandmodalsdropdown);
	public static By getlistboxdropdown=By.xpath(listboxdropdown);
	public static By getothersdropdown =By.xpath(othersdropdown);
	public static By getprogressbars_row =By.xpath(progressbars_row);
	public static By getprogressbars_column =By.xpath(progressbars_column);
	public static By getalertandmodals_row =By.xpath(alertandmodals_row);
	public static By getalertandmodals_column =By.xpath(alertandmodals_column);
	public static By getlistbox_row =By.xpath(listbox_row);
	public static By getlistbox_column =By.xpath(listbox_column);
	public static By getothers_row =By.xpath(others_row);
	public static By getothers_column =By.xpath(others_column);


	//middle nav bar element	
	private static String navbar_demolink = "//*[@class='navbar-header']/div/a";

	public static By getnavbar_demolink=By.xpath(navbar_demolink);

	//carousel
	private static String left_carousel= "//a[1]/i";
	private static String right_carousel= "//a[2]/i";
	private static String byheadinglinks = "#carousel-example-generic h4";

	public static By getleft_carousel=By.xpath(left_carousel);
	public static By getright_carousel=By.xpath(right_carousel);
	public static By getbyheadinglinks=By.cssSelector(byheadinglinks);


	//Treeview
	private static String parentnode = "ul#treemenu li a";
	private static String subtreenodes = ".//*[@id='treemenu']/li[1]/ul/li";

	public static By getparentnode=By.cssSelector(parentnode);
	public static By getsubtreenodes=By.xpath(subtreenodes);

	//Home Bar Board
	private static String tooltip =".tooltip-inner";
	private static String homebar =".//*[@id='home_bar']/span";
	private static String basicexample = "//*[@id='basic_example']/span";
	private static String basicexampletooltip = "li.tab-toggle.active .tooltip-inner";
	private static String intermediate = "//*[@id='inter_example']/span";
	private static String intermediatetooltip = "li.tab-toggle.active .tooltip-inner";
	private static String advanced = "//*[@id='advanced_example']/span";
	private static String advancedtooltip = "li.tab-toggle.active .tooltip-inner";
	private static String completed = ".//*[@id='done_example']/span";
	private static String completedtooltip = "li.active .tooltip-inner";
	
	public static By gettooltip=By.cssSelector(tooltip);
	public static By gethomebar=By.xpath(homebar);
	public static By getbasicexample=By.xpath(basicexample);
	public static By getbasicexampletooltip=By.cssSelector(basicexampletooltip);
	public static By getintermediate=By.xpath(intermediate);
	public static By getintermediatetooltip=By.cssSelector(intermediatetooltip);
	public static By getadvanced=By.xpath(advanced);
	public static By getadvancedtooltip=By.cssSelector(advancedtooltip);
	public static By getcompleted=By.xpath(completed);
	public static By getcompletedtooltip=By.cssSelector(completedtooltip);
	
	//Home Bar Board: Tab Content
	private static String welcomecontentbox =".//*[@id='home']";
	private static String basiccontentbox =".//*[@id='basic']";
	private static String intermediatecontentbox =".//*[@id='intermediate']";
	private static String advancedcontentbox = ".//*[@id='advanced']";
	private static String completedcontentbox = ".//*[@id='completed']";

	public static By getwelcomecontentbox=By.xpath(welcomecontentbox);
	public static By getbasiccontentbox = By.xpath(basiccontentbox);
	public static By getintermediatecontentbox = By.xpath(intermediatecontentbox);
	public static By getadvancedcontentbox = By.xpath(advancedcontentbox);
	public static By getcompletedcontentbox = By.xpath(completedcontentbox);


	//Footer
	private static String tutorialsmenuitem = "//*[@class='footer']/div/div[1]/ul/li";
	private static String popularpostitem = "//*[@class='footer']/div/div[2]/ul/li";

	public static By gettutorialsmenuitem=By.xpath(tutorialsmenuitem);
	public static By getpopularpostitem=By.xpath(popularpostitem);

}
