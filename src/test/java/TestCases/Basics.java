package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Pages.Android.ApiDemosPage;
import TestBase.BaseTest;
import Utility.MyListeners;

@Listeners(MyListeners.class)
public class Basics extends BaseTest{
	private ApiDemosPage user;
	
	//@Test(priority = 1)
	public void EnableWifiSettings() throws Exception {
		user = new ApiDemosPage(getAndroidDriver());
		user.enablingWIFISetting("Milind");
		log("Successfully Enabled WifiSettings");
	}
	
	//@Test(priority = 2)
	public void longpress() throws Exception {
		user = new ApiDemosPage(getAndroidDriver());
		user.longPress();
		user.validatelongpressResult();
	}
	
	//@Test(priority = 3)
	public void swipePics() throws Exception {
		user = new ApiDemosPage(getAndroidDriver());
		user.performGalleryActions();
		user.validateFocusImate();
	}
	
	//@Test(priority = 4)
	public void mislenius() throws Exception {
		user = new ApiDemosPage(getAndroidDriver());
		DeviceRotation landScape = new DeviceRotation(0, 0, 90);
		user.rotateDevice(landScape);
		user.rotateToPortrait();
		user.pressDeviceHomeButton();
		user.pressBackKey(1);
	}
	
	@Test
	public void scrolldown() throws Exception{
		user = new ApiDemosPage(getAndroidDriver());
		androidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		Thread.sleep(3000);
	} 
	
	
}
