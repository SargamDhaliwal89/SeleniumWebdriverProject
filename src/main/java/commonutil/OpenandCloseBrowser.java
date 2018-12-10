package commonutil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import listeners.ScreenshotOnFailure;



public class OpenandCloseBrowser {
	/**
	 * @author sargam
	 * @Designation Test Engineer
	 *
	 */


	protected static WebDriver driver;
	DesiredCapabilities caps;
	protected static ExtentReports report=null;
	protected static ExtentTest logger=null;
	ScreenshotOnFailure screen;
	public static final String USERNAME = "Credentials";
	public static final String AUTOMATE_KEY = "";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@BeforeSuite
	public void pathForExtendReport() {
		report = new ExtentReports("./target/surefire-reports"+"/extendReports/"+"report.html");


	}

	@Parameters({"browser","baseURL"})
	@BeforeMethod
	public void openBrowser(String browser,String baseURL, Method method) throws InterruptedException, MalformedURLException{

		//Thread.sleep(10000);
		logger = report.startTest((this.getClass().getSimpleName()+"::"+method.getName()),method.getName());

		if(browser.equalsIgnoreCase("firefox")){ // here setting done for BrowserStack
			//driver=new FirefoxDriver();
			caps = new DesiredCapabilities();

			caps.setCapability(CapabilityType.PLATFORM,"WINDOWS");
			caps.setCapability(CapabilityType.BROWSER_NAME, browser);
			caps.setCapability(CapabilityType.VERSION,"ANY");
			driver = new RemoteWebDriver(
					new URL(URL),
					caps
					);

			logger.log(LogStatus.INFO, "Browser up and running");
		}

		else if(browser.equalsIgnoreCase("chrome")){
			DesiredCapabilities caps = DesiredCapabilities.chrome();

			caps.setCapability(CapabilityType.PLATFORM,"MAC");
			caps.setCapability(CapabilityType.BROWSER_NAME, browser);
			caps.setCapability(CapabilityType.VERSION,"ANY");
//			caps.setCapability( "browserstack.debug", "true");
//			caps.setCapability( "browserstack.networkLogs", "true");

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"/drivers/chromedriver");
			driver=new ChromeDriver(caps);
//			driver = new RemoteWebDriver(
//					new URL(URL),
//					caps
//					);

			logger.log(LogStatus.INFO, "Browser is up");
		}

		else{

			driver=new FirefoxDriver();
			//			driver = new RemoteWebDriver(
			//					new URL(URL),
			//					caps
			//					);
		}

		driver.get(baseURL);
		//driver.manage().window().maximize();
		logger.log(LogStatus.INFO, "Browser up and running");

		// create file named Cookie to store username Information

		File file = new File(System.getProperty("user.dir")+"/Cookie.data");

		try { // Delete if any old file exists

			file.delete();

			file.createNewFile();

			FileWriter fileWriter = new FileWriter(file);

			BufferedWriter bufferwrite = new BufferedWriter(fileWriter);

			for(Cookie cook : driver.manage().getCookies()){

				String writeup = cook.getName()+";"+cook.getValue()+";"+cook.getDomain()+";"+cook.getPath()+""

		+ ";"+cook.getExpiry()+";"+cook.isSecure();

				bufferwrite.write(writeup);

				//				System.out.println(writeup);

				bufferwrite.newLine();

			}

			bufferwrite.flush();bufferwrite.close();fileWriter.close();

		}catch(Exception exp){

			exp.printStackTrace();

		}
	}

	public static WebDriver getInstance(){
		return driver;
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) throws Exception {
		if(result.getStatus()==ITestResult.FAILURE) {
			screen = new ScreenshotOnFailure();
			screen.onTestFailure(result);
			String screenshot_path=screen.screenshot(result);
			String image= logger.addScreenCapture(screenshot_path);

			logger.log(LogStatus.FAIL, "Testcase " + result.getName()+" has been failed:: "+result.getName()
			+new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ssaa").format(new Date())+".png"+image);
			driver.close();	
		}
		else {
			//driver.get("file:///Users/sargam/Documents/workspace/seleniumeasywebsite/test-output/extendReports/report.html");		
			driver.close();	
			driver.quit();
		}
	}


	@AfterSuite
	public void closeAllBrowser() {
		report.endTest(logger);
		report.flush();	

	}

}
