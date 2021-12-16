package tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests{
	public static WebDriver driver;
	public static String downloadPath = System.getProperty("user.dir")+ "\\downloads";
	
	public static FirefoxOptions firefoxOption()
	{
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("browser.download.folderList", 2);
		options.addPreference("browser.download.dir", downloadPath);
		options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		options.addPreference("browser.download.manger.showWhenStarting", false);
		options.addPreference("pdfjs.disabled", true);
		return options;
	}
	
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

	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void openDriver(@Optional("firefox") String browserName )
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\sources\\chromedriver.exe");
			driver = new ChromeDriver(chromeOption());
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\sources\\geckodriver.exe");
			driver = new FirefoxDriver(firefoxOption());
		}
		else if (browserName.equalsIgnoreCase("headless"))
		{
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
		//	caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
		//			System.getProperty("user.dir")+"\\sources\\phantomjs.exe");
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "D:\\Selinuem\\Demo\\sources\\phantomjs.exe");
			String[] phantomJsArgs = {"--web-security=no","--ignore-ssl-errors=yes"};
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsArgs);
			driver = new PhantomJSDriver(caps);			
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");	
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
