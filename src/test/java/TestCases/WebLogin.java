
package TestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Pages.LegalService;
import TestBase.BaseTest;
import Utility.MyListeners;

@Listeners(MyListeners.class)
public class WebLogin extends BaseTest {
	private LegalService service;
	@Test
	public void webLogin() throws Exception {
		log("User landed on Home Page");
		service = new LegalService(getWebDriver());
		log("Navigated to the Page");
		service.loginSignUpMethod("7072856499", "9999", "sdfsfs", "sfsddmilind.com");
		log("Successfully logged in with Number, OTP, name, and password");
		Thread.sleep(5000);
	}
}
