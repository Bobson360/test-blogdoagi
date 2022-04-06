package pageobjects.pages;

import static org.junit.Assert.assertTrue;

import static utils.Ultils.isMac;
import static utils.Ultils.takeSnapShot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import config.PageBase;

public class NoResultsPage extends PageBase{
	
	WebElement fieldSearch = null;

	public void pageValidation() throws Exception {
		fieldSearch = driver.findElement(By.xpath("//section[@class = 'no-results not-found']//input[@type = 'search']"));
		takeSnapShot(driver);
		assertTrue("Erro ao validar tela \"Nenhum resultado\" ", fieldSearch.isDisplayed());
	}

	public void valueValidationSearchField(String value) throws Exception {
		fieldSearch = driver.findElement(By.xpath("//section[@class = 'no-results not-found']//input[@type = 'search']"));
		String text = fieldSearch.getAttribute("value");
		takeSnapShot(driver);
		assertTrue("Nao foi possivel validar o valor da pesquisa: "
				+ "Valor esperado: [" + value + ", Valor encontrado: " + text + "]", text.equals(value));
	}

	public void searchWithfield(String value) throws Exception {
		fieldSearch = driver.findElement(By.xpath("//section[@class = 'no-results not-found']//input[@type = 'search']"));
		fieldSearch.clear();
		takeSnapShot(driver);
		fieldSearch.sendKeys(value + (isMac() ? Keys.RETURN : Keys.ENTER));
	}

}
