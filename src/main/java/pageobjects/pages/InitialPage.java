package pageobjects.pages;

import static org.junit.Assert.assertTrue;

import static utils.Ultils.isMac;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.PageBase;

public class InitialPage extends PageBase {

	public WebElement btnSearch = driver.findElement(By.xpath("//button[@id = 'search-open']"));
	private WebElement searchField = driver.findElement(By.xpath("//div[@class = 'desktop-search']//input[@name = 's']"));

	public void validaCampoPasquisaAberto() {
		searchField = (new WebDriverWait(driver, 2)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class = 'desktop-search']//input[@name = 's']")));
		Assert.assertTrue("Nao foi possivel validar a exibicao do campo de pesquisa", searchField.isDisplayed());
	}

	public void validaCampoPasquisaFechado() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Thread.sleep(1000);
		searchField = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class = 'desktop-search']//input[@name = 's']")));
		Assert.assertFalse("Nao foi possivel validar a exibicao do campo de pesquisa", searchField.isDisplayed());

	}

	public void validaPlaceHolder() {
		searchField.clear();
		String value = searchField.getAttribute("placeholder");
		assertTrue("Nao foi possivel validar o placeholder: Valor esperado: Pesquisar. Valor encontrado: " + value, 
				value.contains("Pesquisar"));
	}

	public void writeText() {
		assertTrue(null, false);
	}

	public void bntSearchClick() {
		assertTrue(null, false);
	}

	public void pressEnter() {
		assertTrue(null, false);
	}

	public void searchFielValueValidation(String value) {
		assertTrue(null, false);
	}

	public void openSandwich() {
		driver.findElement(By.id("overlay-open")).click();
	}

	public void mobileSearch(String value) {
		driver.findElement(By.xpath("//div[@class = 'mobile-search']//input[@class = 'search-field']"))
		.sendKeys(value + (isMac() ? Keys.RETURN: Keys.ENTER));
	}
}
