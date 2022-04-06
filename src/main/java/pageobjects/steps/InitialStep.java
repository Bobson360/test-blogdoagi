package pageobjects.steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import pageobjects.pages.InitialPage;
import pageobjects.pages.NoResultsPage;
import pageobjects.pages.ResultsPage;

public class InitialStep {

	InitialPage initPage = new InitialPage();
	ResultsPage resultsPage = new ResultsPage();
	NoResultsPage noResultsPage = new NoResultsPage();

	@Dado("clique na lupa de pesquida no canto superior esquerdo")
	public void dado_clique_na_lupa_de_pesquida_no_canto_superior_esquerdo() throws Exception {
		initPage.btnToagleSearch();
	}

	@Entao("devo validar a exibicao do formulario")
	public void entao_devo_validar_a_exibicao_do_formulario() throws Exception {
		initPage.validaCampoPasquisaAberto();
	}

	@Entao("devo validar o fechamento do formulario")
	public void entao_devo_validar_o_fechamento_do_formulario() throws Exception {
		initPage.validaCampoPasquisaFechado();
	}

	@Entao("devo validar o placeholder do form de pesquisa")
	public void entao_devo_validar_o_placeholder_do_form_de_pesquisa() throws Exception {
		initPage.validaPlaceHolder();
	}

	@E("^digitar no campo de pesquisa o texto \"([^\"]*)\"$")
	public void e_eigitar_no_campo_de_pesquisa_o_texto(String value) throws Exception {
		initPage.writeText(value);
	}

	@E("precionar a tecla enter")
	public void e_precionar_a_tecla_enter() throws Exception {
		initPage.pressEnter();
	}

	@E("clicar no botao pesquisar")
	public void e_clicar_no_botao_pesquisar() throws Exception {
		initPage.bntSearchClick();
	}

	@Entao("devo validar a tela de resultados")
	public void entao_devo_validar_a_tela_de_resultados() throws Exception {
		Thread.sleep(1000);
		resultsPage.pageValidation();
	}

	@Entao("validar a tela de nenhum resultado encontrado")
	public void entao_validar_a_tela_de_nenhum_resultado_encontrado() throws Exception {
		noResultsPage.pageValidation();
	}

	@Entao("^o campo de pesquisa com o mesmo texto buscado \"([^\"]*)\"$")
	public void entao_o_campo_de_pesquisa_com_o_mesmo_texto_buscado(String value) throws Exception {
		noResultsPage.valueValidationSearchField(value);
	}

	@E("^pesquisar pelo campo de pesquisa da tela sem resultados o texto \"([^\"]*)\"$")
	public void e_pesquisar_pelo_campo_de_pesquisa_da_tela_sem_resultados_o_texto(String value) throws Exception {
		noResultsPage.searchWithfield(value);
	}

	@Entao("^o valor na caixa de pesquisa deve ser covespondente a \"([^\"]*)\"$")
	public void entao_o_valor_na_caixa_de_pesquisa_deve_ser_covespondente_a(String value) throws Exception {
		initPage.searchFielValueValidation(value);
	}
}
