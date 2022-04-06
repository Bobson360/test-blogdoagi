package test;

import static utils.Props.getProp;
import static utils.Ultils.browser;
import static utils.Ultils.isUnix;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

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
	


}
