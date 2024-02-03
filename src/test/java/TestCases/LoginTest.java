package TestCases;

import Pages.ResidentHomePage;
import TestBase.BaseTest;
import Utility.MyListeners;
import io.appium.java_client.android.AndroidDriver;

import java.awt.Dimension;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtility.CommonAppium;

@Listeners(MyListeners.class)
public class LoginTest extends BaseTest {
	private ResidentHomePage user;

	@Test
	public void TC01_VerifyingLogin() throws Exception {
		user = new ResidentHomePage(getAndroidDriver());
		log("clicking on 'Get Started' Button");
		user.userLogin(EMAIL, PASSWORD);
		log("Successfully Logged in with Email'" + EMAIL + "'And Password'" + PASSWORD + "'");

		user.selectHeaderOptions("Explore");
		log("Clicking on 'Exlore'Options");
 
		user.selectExploreService("Home\nServices");
		log("Clicking on 'Home Services'Options");

		user.selectHomeServiceType();
		log("Clicking on 'Bathroom Cleaning Service'Options");
        
		user.selectBathroomCleaning("2 Bathrooms");
		log("Successfully Added 2 Premium Bathroom Cleaning Service to Cart");
		
		user.addingNewServiceAddress("HSR Layout","A-123","Bren Mercury","Home");
		log("Successfully Added Service Address");
	
		user.selectingServiceDateAndTime("12:30 - 1:00 PM");
		log("Successfully Selectecd Service Date & Slot");
	}

}
