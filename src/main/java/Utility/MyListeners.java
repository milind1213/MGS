package Utility;
import java.io.IOException;
import java.util.Arrays;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListeners implements ITestListener, ISuiteListener {
	ExtentTest test;
	static String messageBody;
	static ExtentReports extent = ExtentReportNG.getReportObject();
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // Thread

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE '" + methodName.toUpperCase() + " ' PASSED" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.get().pass(m); // extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		extentTest.get()
				.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured: Click to View"
						+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>"
						+ " \n");
		try {
			ScreenshotUtils.captureScreenshot();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		extentTest.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of Failure" + "</font>" + "</b>",
				MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtils.screenshotName).build());
		String failureLogg = "<b>" + "FAILED ' " + methodName.toUpperCase() + " ' TEST CASE" + "</b>";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		extentTest.get().log(Status.FAIL, m);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.AMBER);
		extentTest.get().skip(m);
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
