
package TestCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Pages.LegalService;
import TestBase.BaseTest;
import Utility.MyListeners;

@Listeners(MyListeners.class)
public class WebLogin extends BaseTest {
	private LegalService service;
	@Test(priority=1)
	public void TC01_Verify_Instant_Verification_PKG_Functionality() throws Exception {
		service = new LegalService(getWebDriver());
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
	
	@Test(priority=2)
	public void TC02_Verify_Basic_Verification_PKG_Functionality() throws Exception {
		service = new LegalService(getWebDriver());
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
	
	
	
	
}
