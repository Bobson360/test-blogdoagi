package pageobjects.pages;

import static org.junit.Assert.assertTrue;

import static utils.Ultils.isMac;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import config.PageBase;

public class NoResultsPage extends PageBase{
	
	WebElement fieldSearch = null;

	public void pageValidation() {
		fieldSearch = driver.findElement(By.xpath("//section[@class = 'no-results not-found']//input[@type = 'search']"));
		assertTrue("Erro ao validar tela \"Nenhum resultado\" ", fieldSearch.isDisplayed());
	}

	public void valueValidationSearchField(String value) {
		fieldSearch = driver.findElement(By.xpath("//section[@class = 'no-results not-found']//input[@type = 'search']"));
//		String text = fieldSearch.getText();
		String text = fieldSearch.getAttribute("value");
		assertTrue("Nao foi possivel validar o valor da pesquisa: "
				+ "Valor esperado: [" + value + ", Valor encontrado: " + text + "]", text.equals(value));
	}

	public void searchWithfield(String value) {
		fieldSearch = driver.findElement(By.xpath("//section[@class = 'no-results not-found']//input[@type = 'search']"));
		fieldSearch.clear();
		fieldSearch.sendKeys(value + (isMac() ? Keys.RETURN : Keys.ENTER));
	}

}
