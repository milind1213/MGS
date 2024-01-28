package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CommonUtility.SeleniumActions;

public class LegalService extends SeleniumActions {
	WebDriver driver;

	public LegalService(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private By loginLinkBtn = By.xpath("//div[contains(@class,'nav-item-content') and text()='Log in']");
	private By mobileInput = By.xpath("//input[starts-with(@id,'signUp')]");
	private By otpField = By.xpath("//div[@class='flex items-center justify-center']//input");
	private By loginsubmit = By.id("signUpSubmit");
	private By usernameField = By.xpath("//input[@id='name' and  @name = 'name']");
	private By emailField = By.xpath("//input[@id='email' and  @name = 'email']d");
	private By signUpsubmit = By.xpath("//button[text()='Continue']");

	public void loginSignUpMethod(String mobileNumber, String otp, String username, String email) {
		waitFor(5);
		click(loginLinkBtn);
		log("Clicking on Login Button");
		
		waitForElementPresence(driver, mobileInput, 5);
		sendKeys(mobileInput, mobileNumber);
        log("Entering PhoneNumber '"+ mobileNumber +"' in InputField ");
        
		if (isElementPresent(driver, otpField)) {
			sendKeys(otpField, otp);
			log("Entering OTP '"+otp+"' in field");
			
			click(loginsubmit);
			log("Clicking on login Button");
		} else {
			waitForElementPresence(driver, usernameField, 5);
			sendKeys(usernameField, username);
			log("Entering UserName'"+ username +"' in InputField ");
			
			waitForElementPresence(driver, emailField, 5);
			sendKeys(emailField, email);
			log("Entering emailid'"+ email +"'in InputField ");

			waitForElementToBeClickable(driver, signUpsubmit, 5);
			click(signUpsubmit);
			log("Clicking on login Button");

		}
	}
}
