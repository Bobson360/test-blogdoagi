package test;

import static utils.Ultils.isUnix;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.PageBase;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "resources/features", glue = "pageobjects/steps", tags = {"@mobile"})
public class TestMobileSize {
	public static WebDriver driver;
	
	@BeforeClass
	public static void before () {
		System.setProperty("webdriver.chrome.driver", isUnix() ? 
				"/Users/"+System.getProperty("user.name")+"/projects/driver/chromedriver": 
				"C:\\driver\\chromedriver.exe");
		Dimension dem = new Dimension(414,896);
		driver = new ChromeDriver();
		driver.manage().window().setSize(dem);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("https://blogdoagi.com.br/");
		PageBase.driver = driver;	
	}
	
	@AfterClass
	public static void affter () {
		driver.close();
		driver.quit();
	}
	
}
