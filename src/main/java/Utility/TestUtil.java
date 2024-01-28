package Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import CommonUtility.AppiumDriverUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;

public class TestUtil extends AppiumDriverUtils {
	public static String screenshotName;

	public static void captureScreenshot() throws IOException {
		File scrFile;
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy_hh:mm:ss_a");
		screenshotName = now.format(formatter).replace(" ", "_") + ".jpg";
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
