package listeners;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import commonutil.OpenandCloseBrowser;


public class ScreenshotOnFailure extends TestListenerAdapter {
	private WebDriver driver;
	protected SimpleDateFormat dFormat;
	protected String srnshotName;
	private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
	@Override
	public void onTestFailure(ITestResult tr) {
		try {
			screenshot(tr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
	}

	public String screenshot(ITestResult tr) throws IOException{
		System.setProperty(ESCAPE_PROPERTY, "false");
		driver=OpenandCloseBrowser.getInstance();
		File location=new File("./test-output");
		Date date=new Date();
		dFormat=new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ssaa");
		srnshotName=location.getCanonicalPath()+"/screenshot/"+tr.getName()
		+dFormat.format(date)+".png";
		File srnshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srnshot, new File(srnshotName));
		Reporter.log("<H3>Repro Steps</H3><br>"+tr.getMethod().getDescription()+"<br>");
		Reporter.log("<a href="+srnshotName+">Screenshot</a>");

		return srnshotName;




	}


}
