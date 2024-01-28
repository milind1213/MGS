
package TestCases;

import Pages.ResidentHomePage;
import TestBase.BaseTest;
import Utility.MyListeners;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListeners.class)
public class LoginTest extends BaseTest {
	private ResidentHomePage user;
	@Test
	public void verifyingLogin() throws Exception {
		user = new ResidentHomePage(getAndroidDriver());
		log("Succesfully Launched Application");
		log("clicking on 'Get Started' Button");
		user.userLogin(EMAIL, PASSWORD);
		log("Entering Valid Email '"+ EMAIL +"' And Password '"+ PASSWORD +"'");
		log("Logged in Successfully");
		user.selectHeaderOptions("Explore");
		log("Clicking on 'Exlore'Options");
		user.selectExploreService("Home\nServices");
		log("Clicking on 'Home Services'Options");
		user.selectHomeServiceType("Bathroom\nCleaning");
		log("Clicking on 'Bathroom Cleaning Service'Options");
	}

}
