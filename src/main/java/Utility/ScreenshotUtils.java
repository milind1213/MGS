package Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import CommonUtility.AndroidDrivers;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtils extends AndroidDrivers {

	public static String screenshotName;

	public static void captureScreenshot(String methodName) throws IOException {
		File scrFile;
		screenshotName = methodName + ".jpg";
		switch (currentDriver) {
		case ANDROID:
			scrFile = ((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.FILE);
			break;
		case WEB:
			scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			break;
		default:
			throw new IllegalArgumentException("Invalid driver type");
		}

		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "//reports//" + screenshotName));
		FileUtils.copyFile(scrFile, new File(".\\reports\\" + screenshotName));
	}
}
