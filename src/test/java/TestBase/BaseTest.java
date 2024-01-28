
package TestBase;
import CommonUtility.AppiumDriverUtils;
import CommonUtility.WebDriverUtils;
import Utility.MyListeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import java.net.URL;
import java.time.Duration;

public class BaseTest extends AppiumDriverUtils {

	public AndroidDriver getAndroidDriver() throws Exception {
		if (!appiumServer().isRunning()) {
			appiumServer().start();
		}
		androidDriver = new AndroidDriver(new URL(URL), setUiAutomator2Options());
		androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		currentDriver = Driver.ANDROID;
		return androidDriver;
	}

	public WebDriver getWebDriver() {
		driver = new WebDriverUtils().init_driver("chrome");
		currentDriver = Driver.WEB;
		driver.get(WEB_URL);
		return driver;
	}

	@AfterMethod(alwaysRun = true)
	public void quitDriver() {
		if (androidDriver != null) {
			androidDriver.quit();
		}
		if (driver != null) {
			driver.quit();
		}
	} 

	@AfterClass(alwaysRun = true)
	public void quitServer() {
		if (appiumServer() != null && appiumServer().isRunning())
			appiumServer().stop();
	}

	public void log(String message) {
		ExtentTest extentTest = MyListeners.extentTest.get();
		if (extentTest != null) {
			extentTest.log(Status.PASS, message);
		}
        System.out.println(message);
	}

}
