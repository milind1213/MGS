package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CommonUtility.CommonSelenium;

public class FixedDepositPage extends CommonSelenium {
	public WebDriver driver;

	public FixedDepositPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private By principle = By.id("principal");
	private By interest = By.id("interest");
	private By tenure = By.id("tenure");
	private By tenurePeriod = By.id("tenurePeriod");
	private By frequency = By.id("frequency");
	private By calculate_btn = By.xpath("//div[@class='cal_div']//a[1]");
	private By act_value = By.xpath("//span[@id='resp_matval']/strong");
	
	public void calculateFixedDeposit(String princ, String intrest, String prd1, String prd2, String frequncy) {
		sendKeys(principle, princ);
		log("Entering PricipleAmt'"+princ+"'Inputfiled");
		
		sendKeys(interest, intrest);
		log("Entering Rate of Inerest'"+intrest+"'Inputfiled");
		
		sendKeys(tenure, prd1);
		log("Entering Tenure'"+prd1+"'Inputfiled");
		
		selectDropdownOptionByText(driver, tenurePeriod, prd2);
		log("Selecting TenureType'"+prd2+"'DropDpwn Option");
		
		selectDropdownOptionByText(driver, frequency, frequncy);
		log("Selecting Frequncy'"+frequncy+"'DropDpwn Option");
		
		javascriptClick(calculate_btn);
		log("clickin on Calculate Button");
	}
	
	public String gettotalValue(){
		String actValue = driver.findElement(act_value).getText();
		return actValue;
	}
}
















