package utils;

import static utils.Props.getBooleanProp;
import static utils.Props.getProp;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * 
 * @author Robson Rodrigues
 * @since 05/04/2022
 * 
 * Utilidades para automacao
 *
 */
public class Ultils {

	/**
	 * Valida se execucao ocorre em sistema unix
	 * @return
	 */
	public static boolean isUnix() {
		return !System.getProperty("os.name").toLowerCase().contains("win");
	}

	
	/**
	 * Verifica se o sistema em questao e mac os
	 * @return
	 */
	public static boolean isMac() {
		return System.getProperty("os.name").toLowerCase().contains("mac");
	}

	/**
	 * Obtem do arquivo properties qual o browser executar
	 * @return
	 * @throws IOException
	 */
	public static WebDriver browser() throws IOException {
		switch (getProp().getProperty("browser").toString()) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			return getBooleanProp("chrome.headless") ? new ChromeDriver(options) : new ChromeDriver();
		case "firefox":
			return new FirefoxDriver();
		case "safari":
			return new SafariDriver();

		}
		return null;
	}

/**
 * Take a Screenshot from webpage
 * 
 * @param webdriver
 * @throws Exception
 */
	public static void takeSnapShot(WebDriver webdriver) throws Exception {

		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination
		File DestFile = new File(
				"target/" + new SimpleDateFormat("yyyy/MM/dd").format(new Date()) + new Date().getTime() + ".png");

		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);

	}
}
