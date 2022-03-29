package pageobjects.pages;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.PageBase;

public class InitialPage extends PageBase {

	public WebElement btnSearch = driver.findElement(By.xpath("//button[@id = 'search-open']"));
	private WebElement searchField;

	public void validaCampoPasquisaAberto() {
		searchField = (new WebDriverWait(driver, 2)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class = 'desktop-search']//input[@name = 's']")));
		Assert.assertTrue("Não foi possivel validar a exibição do campo de pesquisa", searchField.isDisplayed());
	}

	public void validaCampoPasquisaFechado() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Thread.sleep(1000);
		searchField = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class = 'desktop-search']//input[@name = 's']")));
		Assert.assertFalse("Não foi possivel validar a exibição do campo de pesquisa", searchField.isDisplayed());

	}

	public void validaPlaceHolder() {
		assertTrue(null, false);
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
}
