package pageobjects.steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import pageobjects.pages.InitialPage;

public class MobileStep {
	InitialPage initPage = new InitialPage();

	@Dado("que eu expanda o menu sandwich")
	public void dado_que_eu_expanda_o_menu_sandwich() {
		initPage.openSandwich();
	}

	@E("pesquise no campo de de busca por \"([^\"]*)\"$")
	public void e_clique_na_lupa_depesquida_no_canto_superior_esquerdo(String value) {
		initPage.mobileSearch(value);
	}

}
