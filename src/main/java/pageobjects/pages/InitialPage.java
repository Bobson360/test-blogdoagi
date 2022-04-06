package pageobjects.pages;

import static org.junit.Assert.assertTrue;

import static utils.Ultils.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.PageBase;

public class InitialPage extends PageBase {

	public WebElement btnSearch = driver.findElement(By.xpath("//div[@class = 'desktop-search']//input[@type = 'submit']"));
	private WebElement searchField = driver.findElement(By.xpath("//div[@class = 'desktop-search']//input[@name = 's']"));

	public boolean validaCampoPasquisaAberto() throws Exception {
		searchField = (new WebDriverWait(driver, 2)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class = 'desktop-search']//input[@name = 's']")));
		takeSnapShot(driver);
		Assert.assertTrue("Nao foi possivel validar a exibicao do campo de pesquisa", searchField.isDisplayed());
		return searchField.isDisplayed();
	}

	public void validaCampoPasquisaFechado() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Thread.sleep(1000);
		takeSnapShot(driver);
		searchField = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class = 'desktop-search']//input[@name = 's']")));
		Assert.assertFalse("Nao foi possivel validar a exibicao do campo de pesquisa", searchField.isDisplayed());

	}

	public void validaPlaceHolder() throws Exception {
		searchField.clear();
		String value = searchField.getAttribute("placeholder");
		takeSnapShot(driver);
		assertTrue("Nao foi possivel validar o placeholder: Valor esperado: Pesquisar. Valor encontrado: " + value, 
				value.contains("Pesquisar"));
	}

	public void writeText(String value) throws Exception {
		if(!searchField.isDisplayed()) btnToagleSearch() ;
		searchField.clear();
		searchField.sendKeys(value);
		takeSnapShot(driver);
	}

	public void bntSearchClick() throws Exception {
		btnSearch.click();
		takeSnapShot(driver);
	}

	public void pressEnter() throws Exception {
		searchField.sendKeys(isMac() ? Keys.RETURN: Keys.ENTER);
		takeSnapShot(driver);
	}

	public void searchFielValueValidation(String value) throws Exception {
		WebElement searchField1 = driver.findElement(By.xpath("//div[@class = 'desktop-search']//input[@name = 's']"));
		String text = searchField1.getAttribute("value");
		takeSnapShot(driver);
		assertTrue("Nao foi possivel validar o valor da pesquisa: Valor esperado: [" + value + ", Valor encontrado: " + text + "]", text.equals(value));
	}

	public void openSandwich() throws Exception {
		driver.findElement(By.id("overlay-open")).click();
		takeSnapShot(driver);
	}

	public void mobileSearch(String value) throws Exception {
		driver.findElement(By.xpath("//div[@class = 'mobile-search']//input[@class = 'search-field']"))
		.sendKeys(value + (isMac() ? Keys.RETURN: Keys.ENTER));
		takeSnapShot(driver);
	}

	public void btnToagleSearch() throws Exception {
		driver.findElement(By.xpath("//button[@id = 'search-open']")).click();
		takeSnapShot(driver);
	}
	
}
