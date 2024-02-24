package Pages.Android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

import CommonUtility.CommonAppium;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ApiDemosPage extends CommonAppium {
	public AndroidDriver driver;
	public ApiDemosPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	} 

	// WIFI
		@AndroidFindBy(accessibility = "Preference")
		public WebElement preference;
		
		@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='3. Preference dependencies']")
		private WebElement preferenceDependency;
		
		@AndroidFindBy(id = "android:id/checkbox")
		private WebElement wifiCheckBox;
		
		@AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[2]")
		private WebElement wifiSettings;
		
		@AndroidFindBy(id = "android:id/edit")
		private WebElement editField;
		
		@AndroidFindBy(id="android:id/button1")
		private WebElement okBtn;
		
		@AndroidFindBy(id = "android:id/title")
		private WebElement titleElement;
		
		@AndroidFindBy(className = "android.widget.Button")
		private List<WebElement> buttons;

		
		@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Views']")
		private WebElement view;
		
		public void swipeDowns() {
			view.click();
			swipeDown(5,driver);
			
		}
		
		
		
		
		
		
		
		public void enablingWIFISetting(String wifiName) {
			preference.click();
			log("Clicking on Preference Button");

			preferenceDependency.click();
			log("Clicking on PreferenceDependency");

			wifiCheckBox.click();
			log("Clicking on wifiCheckBox");
			
			wifiSettings.click();
			log("Clicking on wifiSettings");
			
			editField.sendKeys(wifiName);
			log("Entering WIFI User Name");
			okBtn.click();
			log("Clicking on 'Ok' Button");
		}

		public void clickButtonByIndex(int index) {
			buttons.get(index).click();
		}

		public void mns() {
			driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		}

	//LONGPRESS 

		@AndroidFindBy(accessibility = "Views")
		private WebElement views;

		@AndroidFindBy(xpath = "//android.widget.TextView[@text='Expandable Lists']")
		private WebElement expandableLists;

		@AndroidFindBy(accessibility = "1. Custom Adapter")
		private WebElement customAdapter;

		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"People Names\"]")
		private WebElement peopleNames;

		@AndroidFindBy(id = "android:id/title")
		private WebElement title;

		public void longPress() {
			views.click();
			expandableLists.click();
			customAdapter.click();
			longPressAction(peopleNames);
		}

		public void validatelongpressResult() {
			String menuText = title.getText();
			AssertJUnit.assertEquals(menuText, "Sample menu");
			AssertJUnit.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		}

//	 	SWIPE ACTION

		@AndroidFindBy(accessibility = "Gallery")
		private WebElement gallery;

		@AndroidFindBy(xpath = "//android.widget.TextView[@text='1. Photos']")
		private WebElement photos;

		@AndroidFindBy(xpath = "(//android.widget.ImageView)[1]")
		private WebElement firstImage;

		public void performGalleryActions() {
			views.click();
			gallery.click();
			photos.click();
		}

		public void validateFocusImate() {
			AssertJUnit.assertEquals(firstImage.getAttribute("focusable"), "true");
			swipeAction(firstImage, "left");
			AssertJUnit.assertEquals(firstImage.getAttribute("focusable"), "false");
		}

	
	
}
