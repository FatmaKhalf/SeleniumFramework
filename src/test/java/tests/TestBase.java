package tests;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests{
	public static WebDriver driver;
	public static String downloadPath = System.getProperty("user.dir")+ "\\downloads";
	
	public static ChromeOptions chromeOption()
	{
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
		
	}

	@BeforeSuite
	public void openDriver()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\sources\\chromedriver.exe");
		driver = new ChromeDriver(chromeOption());
		driver.navigate().to("https://demo.nopcommerce.com/");	
		driver.manage().window().maximize();
	}

	@AfterSuite
	public void closeDriver()
	{
		//driver.quit();
	}

	@AfterMethod
	public void screenshootOnFailure(ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Faild");
			System.out.println("Taking Screenshot");
			Helper.captureScreenShot(driver, result.getName());
		}
	}


}
