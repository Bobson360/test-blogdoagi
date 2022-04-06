package test;

import static utils.Props.getProp;
import static utils.Props.getBooleanProp;
import static utils.Ultils.isUnix;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import config.PageBase;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import junit.framework.TestCase;

@RunWith(Cucumber.class)
@CucumberOptions(features = "resources/features", glue = "pageobjects/steps", tags = {"@web"})
public class TestDesktopSize extends TestCase{
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void before () throws IOException {
		System.setProperty("webdriver." + getProp().getProperty("browser").toString()+ ".driver", 
				getProp().getProperty(isUnix()? "driver.path.unix" : "driver.path.win").toString());
		
		
		
		driver = browser();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://blogdoagi.com.br/");
		driver.manage().window().maximize();
		PageBase.driver = driver;	
	}
	
	@AfterClass
	public static void affter () {
		driver.quit();
	}
	
	public static WebDriver browser() throws IOException {
		switch (getProp().getProperty("browser").toString()) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			return  getBooleanProp("chrome.headless") ? new ChromeDriver(options): new ChromeDriver();
		case "firefox":
			return new FirefoxDriver();
		case "safari":
			return new SafariDriver();

		}
		return null;
	}

}
