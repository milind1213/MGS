
package TestCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Pages.LegalServicePage;
import TestBase.BaseTest;
import Utility.MyListeners;

@Listeners(MyListeners.class)
public class WebLogin extends BaseTest {
	private LegalServicePage service;
	@Test
	public void webLogin() throws Exception {
		log("User landed on Home Page");
		service = new LegalServicePage(getWebDriver());
		log("Navigated to the Page");
		service.loginSignUpMethod("7072856499", "9999", "sdfsfs", "sfsddmilind.com");
		log("Successfully logged in with Number, OTP, name, and password");
		Thread.sleep(5000);
	}

	public void  TC01_Instant_TV_Package() throws Exception {
		service = new LegalServicePage(getWebDriver());
		service.loginSignUpMethod(randomMobileNumber(),"9999",randomName(),randomEmail());
		log("Successfully logged in with valid credentials.");
		
		service.selectHSServiceType("Painting & Cleaning");  
		log("Clicking on 'Painting & Cleaning' Service");
		
		service.selectHSServiceCity("Bangalore");
		log("Selected 'Bangalore' City");
		
		service.selectTenantVerification("Tenant Verification");
		log("Clicking on 'Tenant Verification' Package");
		
		service.closingChatHelp();
		log("Minimising the 'Help' Pop Up");
		
		service.selectTenantVerificationPackage("Instant Verification");
		log("Selecting the 'Instant Verification' Package");
	
		service.tenantVerificationDetails("PAN Card","BREPG1234F","Milind","11112000");
		log("Succfully Entered Tenant Verification Details ");
	
		service.SaveAndContinueBtn();
		
		String summaryTitle = service.getTvPackageTitle();
        Assert.assertEquals(summaryTitle,"Instant Verification");
	}

	public void TC02_Basic_TV_Package() throws Exception {
		service = new LegalServicePage(getWebDriver());
		service.loginSignUpMethod(randomMobileNumber(),"9999",randomName(),randomEmail());
		log("Successfully logged in with valid credentials.");
		
		service.selectHSServiceType("Painting & Cleaning");
		log("Clicking on 'Painting & Cleaning' Service");
		
		service.selectHSServiceCity("Bangalore");
		log("Selected 'Bangalore' City");
		
		service.selectTenantVerification("Tenant Verification");
		log("Clicking on 'Tenant Verification' Package");
		
		service.closingChatHelp();
		log("Minimising the 'Help' Pop Up"); 
		
		service.selectTenantVerificationPackage("Basic Verification");
		log("Selecting the 'Basic Verification' Package");
		
		service.tenantBasicVerificationDetails("PAN Card","BREPG1234F","Shown","9876543210","11112000","John Doe");
		log("Succfully Entered Tenant Verification Details ");
		
		service.verificationAddress("A-12011","HSR","560035");
		log("Succfully Entered Verification 'Address' Details ");

		String summaryTitle = service.getTvPackageTitle();
        Assert.assertEquals(summaryTitle,"Basic Verification");
	}

	public void TC03_Standard_TV_Package() throws Exception {
		service = new LegalServicePage(getWebDriver());
		service.loginSignUpMethod(randomMobileNumber(),"9999",randomName(),randomEmail());
		log("Successfully logged in with valid credentials.");
		
		service.selectHSServiceType("Painting & Cleaning");
		log("Clicking on 'Painting & Cleaning' Service");
		
		service.selectHSServiceCity("Bangalore");
		log("Selected 'Bangalore' City");
		
		service.selectTenantVerification("Tenant Verification");
		log("Clicking on 'Tenant Verification' Package");
		
		service.closingChatHelp();
		log("Minimising the 'Help' Pop Up"); 
		
		service.selectTenantVerificationPackage("Standard Verification");
		log("Selecting the 'Standard Verification' Package");
		
		service.tenantBasicVerificationDetails("PAN Card","BREPG1234F","Shown","9876543210","11112000","John Doe");
		log("Succfully Entered Tenant Verification Details ");
		
		service.verificationAddress("A-12011","HSR","560035");
		log("Succfully Entered Verification 'Address' Details ");
		

		String summaryTitle = service.getTvPackageTitle();
        Assert.assertEquals(summaryTitle,"Standard Verification");}
	
	

	public void TC04_Comprehensive_TV_Package() throws Exception {
		service = new LegalServicePage(getWebDriver());
		service.loginSignUpMethod(randomMobileNumber(),"9999",randomName(),randomEmail());
		log("Successfully logged in with valid credentials.");
		
		service.selectHSServiceType("Painting & Cleaning");
		log("Clicking on 'Painting & Cleaning' Service");
		
		service.selectHSServiceCity("Bangalore");
		log("Selected 'Bangalore' City");
		
		service.selectTenantVerification("Tenant Verification");
		log("Clicking on 'Tenant Verification' Package");
		
		service.closingChatHelp();
		log("Minimising the 'Help' Pop Up"); 
		
		service.selectTenantVerificationPackage("Comprehensive Verification");
		log("Selecting the 'Comprehensive Verification' Package");
		
		service.tenantBasicVerificationDetails("PAN Card","BREPG1234F","Shown","9876543210","11112000","John Doe");
		log("Succfully Entered Tenant Verification Details ");
		
		service.verificationAddress("A-12011","HSR","560035");
		log("Succfully Entered Verification 'Address' Details ");
	
        service.referenceName("John","8766773456","refrence@g.com");
	    log("Succfully Entered Reference Details ");
	    
	    String summaryTitle = service.getTvPackageTitle();
        Assert.assertEquals(summaryTitle,"Comprehensive Verification");
	}
}