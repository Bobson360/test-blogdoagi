package pageobjects.pages;

import static org.junit.Assert.assertTrue;
import static utils.Ultils.takeSnapShot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import config.PageBase;

public class ResultsPage extends PageBase {

	public void pageValidation() throws Exception {
		List<WebElement> articles = driver.findElements(By.xpath("//div[@id = 'primary']/article"));
		takeSnapShot(driver);
		assertTrue("Nenhum artigo encontrado", articles.size() > 0);
	}

}
