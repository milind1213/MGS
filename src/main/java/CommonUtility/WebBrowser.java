package CommonUtility;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import Utility.ConfigPropReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebBrowser {
    public static ConfigPropReader config = new ConfigPropReader();
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    protected static WebDriver driver;
    public WebDriver init_driver(String browser) {
        boolean isHeadless = Boolean.parseBoolean(config.prop("Web").getProperty("headless"));
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if (isHeadless) {
            	System.out.println("Headless Browser Started");
                options.addArguments("headless");
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("autofill.profile_enabled", false);
                prefs.put("profile.default_content_setting_values.notifications", 2);
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.setExperimentalOption("prefs", prefs);
                options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
            } else {
                options.addArguments("--force-device-scale-factor=0.8");
            }
            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies(); 
            tlDriver.set(driver);
        }
        return tlDriver.get();
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
