package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import CommonUtility.AppiumAndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ResidentHomePage extends AppiumAndroidActions {
	AndroidDriver driver;

	public ResidentHomePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.app.nobrokerhood:id/btnGetStarted")
	public WebElement getStarted;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/editTextEmailMobile")
	public WebElement userEmailID;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/editTextPassword")
	public WebElement password;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/buttonLogin")
	public WebElement loginButton;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/loginCheckbox")
	public WebElement loginWithOTP;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/textViewSignUp")
	public WebElement signUp;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/denyTextView")
	public WebElement Deny;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/imageCross")
	public WebElement closeButton;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/skipTextView")
	public WebElement skip;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/loginCheckbox")
	public WebElement loginWithOTPCheckbox;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/textViewSubmit")
	public WebElement submit;

	@AndroidFindBy(accessibility = "Home")
	public WebElement home;

	@AndroidFindBy(id = "permission_allow_button")
	public WebElement allowAudioRecordPermission;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/allowTextView")
	public WebElement allowMissingNotification;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement allowBacgroundRun;

	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
	public WebElement denyAudioRecordPermission;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/denyTextView")
	public WebElement denyMissingNotification;

	@AndroidFindBy(id = "android:id/button")
	public WebElement denyBacgroundRun;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/fbCloseBtn")
	public WebElement closeContinueBooking;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/frame_layout")
	WebElement frameLayout;


	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.app.nobrokerhood:id/titleTextView' and @text='Food']")
	WebElement exploreOptions;
	
	
	@AndroidFindBy(id ="//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout")
	WebElement exploreframeLayout;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.app.nobrokerhood:id/titleTextView' and @text='Explore']")
	WebElement exploreMenu;
	
	
	
	public void selectHeaderOptions(String str) {
		WebElement headerOption = driver.findElement(By.xpath(String.format("//android.widget.TextView[@resource-id='com.app.nobrokerhood:id/titleTextView' and @text='%s']", str)));
		waitForWebElementToBeClickable(headerOption,Duration.ofSeconds(3));
		click(headerOption); 
	}

	public void selectExploreService(String service) {
		WebElement expService = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.nobrokerhood:id/titleTextView' and @text='service']".replace("service",service)));
		waitForWebElementToBeClickable(expService,Duration.ofSeconds(3));
		expService.click();
	}
	
	public void selectHomeServiceType(String hsService) {
		WebElement hs= driver.findElement(By.xpath("//android.widget.TextView[@text='HS']".replace("HS",hsService)));
		waitForWebElementToBeClickable(hs,Duration.ofSeconds(5));
	    hs.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public void userLogin(String email, String pass) throws InterruptedException {
		try {
			waitForWebElementToBeClickable(getStarted, Duration.ofSeconds(3));
			clickWithoutWait(getStarted);
			wait(1);
			userEmailID.sendKeys(email);
			password.sendKeys(pass);
			loginButton.click();
			if (isElementDisplayed(closeContinueBooking)) {
				clickWithoutWait(closeContinueBooking);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to perform user login. Exception details: " + e.getMessage());
		}
	}


	
	public void allowPermission() {
		if (isElementPresent(allowAudioRecordPermission)) {
			allowAudioRecordPermission.click();
			// log("Allowing AudioRecord Permission");
		}

		if (isElementPresent(allowMissingNotification)) {
			allowMissingNotification.click();
			// log("Allowing MissingNotification Permission");
		}
		if (isElementPresent(allowBacgroundRun)) {
			allowBacgroundRun.click();
			// log("Allowing BackgroundRun Permission");
		}
	}
}
