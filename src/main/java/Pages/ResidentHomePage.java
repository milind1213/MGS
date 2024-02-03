package Pages;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import CommonUtility.CommonAppium;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ResidentHomePage extends CommonAppium {
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

	@AndroidFindBy(id = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout")
	WebElement exploreframeLayout;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.app.nobrokerhood:id/titleTextView' and @text='Explore']")
	WebElement exploreMenu;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.app.nobrokerhood:id/titleTextView' and @text='Explore']")
	WebElement Explore;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='service-page-proceed' and @text='Proceed']")
	WebElement proceedBtn;

	@AndroidFindBy(xpath = "//android.widget.Image[@text=\"google-maps\"]")
	WebElement googleMapIcon;

	private String numberOfBathroomstext = "//android.view.View[@text='bathrooms']";
	private By serviceTag = By
			.xpath("//android.view.View[@text='Premium']/following-sibling::android.widget.Button[@text='ADD']");
	// private By singleBathroom = By.xpath("//android.view.View[@text=\"1
	// Bathroom\"]");
	private By searchAddressTextBox = By.xpath("//android.widget.EditText");
	private By suggestAddress = By
			.xpath("//android.view.View[@resource-id=\"autocomplete-dropdown-container\"]//android.view.View");
	private By confirmLocation = By.xpath("//android.view.View[@text=\"Confirm location\"]");
	private String addressTag = "//android.widget.Button[@resource-id=\"saveAs\" and @text=\" tag\"]";
	private By submitAddress = By.xpath("//android.widget.Button[@resource-id='submit-address' and @text='Proceed']");
	private By doneBtn = By.xpath("//android.view.View[@text=\"Done\"]");
	private By datelocator = By.xpath("(//android.view.View[@resource-id=\"date-container\"]//android.view.View)[2]");
	private By checkOuttDetails = By.xpath("//android.view.View[@text=\"Packages\"]");
	private By nbCash = By.xpath("//android.view.View[@text=\"Redeem NBcash on this order\"]");
	private By houseNo = By.xpath("//android.widget.EditText[@resource-id=\"houseNumber\"]");
    private By socName = By.xpath("//android.widget.EditText[@resource-id=\"address\"]");
    private By slotProceed = By.xpath("//*[@resource-id='slots-proceed-mobile' or @text='Proceed']");
    
    
	public void selectBathroomCleaning(String bathrooms) {
		swipeDown(1, driver);
		log("Scrolling Down till Element");

		WebElement addButton = driver.findElement((serviceTag));
		waitForWebElementToBeClickable(addButton, Duration.ofSeconds(5));
		addButton.click();
		log("Clicking on 'ADD' Button ");

		WebElement numberOfBathrooms = driver
				.findElement(By.xpath(numberOfBathroomstext.replace("bathrooms", bathrooms)));
		click(numberOfBathrooms);
		wait(2);
		click(proceedBtn);
		log("Clicking on Number of'" + bathrooms + "'And Proceeding Button");

		wait(2);
		click(proceedBtn);
		log("Clicking on 'Proceed' Button from Service Addons");

		wait(3);
		click(proceedBtn);
		log("Clicking on 'Proceed' Button from Service Addons");
	}

	public void addingNewServiceAddress(String locality, String houseNumber, String societyName, String tag) {
		wait(2);
		WebElement newAdd = driver.findElement(By.xpath("//android.widget.TextView[@text='Add New Address']"));
		if (isElementDisplayed(newAdd)) {
			newAdd.click();
			log("Clicking on 'Add New Address'");
		} else {
			waitForWebElementToBeClickable(newAdd, Duration.ofSeconds(3));
			newAdd.click();
			log("Clicking on 'Add New Address'");
		}
		wait(5);
		
		sendKeys(driver.findElement(searchAddressTextBox), locality);
		log("Entering Address in Searchbar '" + locality + "'");
 
		click(driver.findElement(suggestAddress));
		log("Selecting Auto-Suggest Address from Options");

		click(driver.findElement(confirmLocation));
		log("Confirming locality ");
        
		sendKeys(driver.findElement(houseNo), houseNumber);
		log("Entering House Number '" + houseNumber + "'");

		sendKeys(driver.findElement(socName), societyName);
		log("Entering Society Name as '" + societyName + "'");

		driver.findElement(By.xpath(addressTag.replace("tag", tag))).click();
		log("Selecting Address tag as '" + tag + "'");
 
		click(driver.findElement(submitAddress));
		log("Clicking on 'Proceed' Button");

		click(driver.findElement(doneBtn));
		log("Clicking on Choose an Address 'Done' Button");

	}

	public void selectingServiceDateAndTime(String slot) {
		click(driver.findElement(datelocator));
		log("Clicking on Service 'Date' Options");

		click(driver.findElement(datelocator));
		log("Clicking on Service 'Date' Options");

		String serviceSlot = "//android.view.View[@text='slot']";
		driver.findElement(By.xpath(serviceSlot.replace("slot", slot))).click();
		log("Selecting Service Slot '" + slot + "'");

		driver.findElement(slotProceed).click();
		log("Clicking On 'Proceed' Button");
 
		wait(3);
		scrollIntoViewByText("Redeem NBcash on this order");
		click(driver.findElement(nbCash));
		log("Applying 'NBcash' Discount");
	}

	public void selectHeaderOptions(String headerOptions) {
		WebElement Options = driver.findElement(By.xpath(
				"//android.widget.TextView[@resource-id='com.app.nobrokerhood:id/titleTextView' and @text='Explore']"
						.replace("Explore", headerOptions)));
		waitForWebElementToBeClickable(Options, Duration.ofSeconds(5));
		click(Options);
	}

	public void selectExploreService(String service) {
		WebElement expService = driver.findElement(By.xpath(
				"//android.widget.TextView[@resource-id='com.app.nobrokerhood:id/titleTextView' and @text='service']"
						.replace("service", service)));
		waitForWebElementToBeClickable(expService, Duration.ofSeconds(3));
		expService.click();
	}

	public void selectHomeServiceType() {
		wait(2);
		WebElement hs = driver
				.findElement(By.xpath("//android.view.View[contains(@text, 'best seller')]/parent::android.view.View"));
		if (isElementDisplayed(hs)) {
			hs.click();
		} else {
			waitForWebElementToBeClickable(hs, Duration.ofSeconds(5));
			hs.click();
		}
		wait(5);
		scrollIntoViewByText("Premium");
	}

	public void selectBathroomCleaningService() {
		WebElement essentialBathroomCLeaning = driver.findElement(By.xpath(
				"//android.view.View[@text='2 Essential bathroom cleaning']/following-sibling::android.widget.Button[@text='ADD']"));
		if (isElementDisplayed(essentialBathroomCLeaning)) {
			essentialBathroomCLeaning.click();
		} else {
			waitForWebElementToBeClickable(essentialBathroomCLeaning, Duration.ofSeconds(5));
			essentialBathroomCLeaning.click();
		}
	}

	public void addButton() {
		WebElement ele = driver.findElement(By.xpath("(//android.widget.Button[@text=\"ADD\"])[2]"));
		ele.click();
	}

	public void clickingProccedingBtn() {
		WebElement ele = driver.findElement(By.xpath("//android.widget.Button[@resource-id='service-page-proceed']"));
		if (isElementDisplayed(ele)) {
			click(ele);
		} else {
			waitForWebElementToBeClickable(ele, Duration.ofSeconds(2));
			click(ele);
		}
	}

	public void clickingCart() {
		WebElement bh = driver.findElement(By.xpath("//android.widget.Image[@text='cart']"));
		waitForWebElementToBeClickable(bh, Duration.ofSeconds(10));
		click(bh);
	}

	public void userLogin(String email, String pass) throws InterruptedException {
		try {
			waitForWebElementToBeClickable(getStarted, Duration.ofSeconds(3));
			click(getStarted);
			wait(1);
			userEmailID.sendKeys(email);
			password.sendKeys(pass);
			loginButton.click();
			if (isElementDisplayed(closeContinueBooking)) {
				click(closeContinueBooking);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to perform user login. Exception details: " + e.getMessage());
		}
		wait(2);

	}

	public void allowPermission() {
		if (isElementPresent(allowAudioRecordPermission)) {
			allowAudioRecordPermission.click();
			log("Allowing AudioRecord Permission");
		}
		if (isElementPresent(allowMissingNotification)) {
			allowMissingNotification.click();
			log("Allowing MissingNotification Permission");
		}
		if (isElementPresent(allowBacgroundRun)) {
			allowBacgroundRun.click();
			log("Allowing BackgroundRun Permission");
		}
	}

}
