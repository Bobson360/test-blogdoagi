package test;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import config.PageBase;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "resources/features", glue = "pageobjects/steps", tags = {"@mobile"})
public class TestMobileSize {
	public static WebDriver driver;
	
	@BeforeClass
	public static void before () {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		Dimension dem = new Dimension(414,896);
		 driver.manage().window().setSize(dem);
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("https://phptravels.net/admin");
		PageBase.driver = driver;	
	}
	
	@AfterClass
	public static void affter () {
		driver.close();
		driver.quit();
	}
	
}
