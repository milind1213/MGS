
package TestBase;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import CommonUtility.AppiumDriverUtils;
import CommonUtility.WebDriverUtils;
import Utility.MyListeners;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest extends AppiumDriverUtils {
	public Logger logger = LogManager.getLogger(this.getClass());

	public void log(String message) {
		logger.info(message);
	}

	public AndroidDriver getAndroidDriver() throws Exception {
		if (!appiumServer().isRunning()) {
			appiumServer().start();
			log("Appium Server Started");
		}
		androidDriver = new AndroidDriver(new URL(URL), setUiAutomator2Options());
		log("Launched Application");
		androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		currentDriver = Driver.ANDROID;
		return androidDriver;
	}

	public WebDriver getWebDriver() {
		driver = new WebDriverUtils().init_driver("chrome");
		log("Chrome Browser Launched");
		currentDriver = Driver.WEB;
		driver.get(WEB_URL);
		log("Navigated to: " + WEB_URL);
		return driver;
	}

	@AfterMethod(alwaysRun = true)
	public void quitDriver() {
		if (androidDriver != null) {
			androidDriver.quit();
			log("Application Closed");
		}
		if (driver != null) {
			driver.quit();
			log("WebBrowser Closed");
		}
	}

	@AfterClass(alwaysRun = true)
	public void quitServer() {
		if (appiumServer() != null && appiumServer().isRunning()) {
			appiumServer().stop();
			log("Appium Server Stoped");
		}
	}

	public void logs(String message) {
		String timestamp = new SimpleDateFormat("h:mm:ss a").format(new Date());
		ExtentTest extentTest = MyListeners.extentTest.get();
		if (extentTest != null) {
			extentTest.log(Status.PASS, message);
		}
		System.out.println("[" + timestamp + "] " + "INFO: " + message);
	}

	public static String randomMobileNumber() {
		return "665" + RandomStringUtils.randomNumeric(4) + "321";
	}

	public static String randomEmail() {
		return RandomStringUtils.randomAlphabetic(4).toLowerCase() + "@g.com";
	}

	public static String randomName() {
		return "NAME " + RandomStringUtils.randomAlphabetic(3).toUpperCase();
	}

}
