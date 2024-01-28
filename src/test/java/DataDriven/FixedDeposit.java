package DataDriven;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Pages.FixedDepositPage;
import TestBase.BaseTest;
import Utility.ExcelUtils;
import Utility.MyListeners;
@Listeners(MyListeners.class)
public class FixedDeposit extends BaseTest {
	private FixedDepositPage user;
	private String princAmt;
	private String rateOfInterest;
	private String period;
	private String periodType;
	private String frequncy;
	private String exp_mvalue;

	@Test
	public void fixedDepositInterestCalculation() throws Exception {
		user = new FixedDepositPage(getWebDriver());
		System.setProperty("excel.file.path",
				"/home/milind/eclipse-workspace/projects/mobile/MobileAutomation/resource/TestData/caldata.xlsx");
		String file = System.getProperty("excel.file.path");
		int rows = ExcelUtils.getRowCount(file, "Sheet1");
		for (int i = 1; i <= rows; i++) {
			princAmt = ExcelUtils.getCellData(file, "Sheet1", i, 0);
			rateOfInterest = ExcelUtils.getCellData(file, "Sheet1", i, 1);
			period = ExcelUtils.getCellData(file, "Sheet1", i, 2);
			periodType = ExcelUtils.getCellData(file, "Sheet1", i, 3);
			frequncy = ExcelUtils.getCellData(file, "Sheet1", i, 4);
			exp_mvalue = ExcelUtils.getCellData(file, "Sheet1", i, 5);

			user.calculateFixedDeposit(princAmt, rateOfInterest, period, periodType, frequncy);
			String ActVal = user.gettotalValue();
			Double act_Value = Double.parseDouble(ActVal);

			if (Double.parseDouble(exp_mvalue) == act_Value) {
				System.out.println("Test Passsed");
				ExcelUtils.setCellData(file, "Sheet1", i, 7, "Passed");
				ExcelUtils.fillGreenColor(file, "Sheet1", i, 7);
			} else {
				System.out.println("Test Failed");
				ExcelUtils.setCellData(file, "Sheet1", i, 7, "Failed");
				ExcelUtils.fillRedColor(file, "Sheet1", i, 7);
			}
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement clear_btn = driver.findElement(By.xpath("//img[@class='PL5']"));
			js.executeScript("arguments[0].click();", clear_btn); // clicking on clear button
			log("Clearing the Entered the Text"); 
		}

	}

}