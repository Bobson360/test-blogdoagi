package pageobjects.steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import pageobjects.pages.InitialPage;

public class MobileStep {
	InitialPage initPage = new InitialPage();
	
	 @Dado("que esteja na tela inicial")
	 public void dado_que_esteja_na_tela_inicial() {
		 
	 }
	    @E("clique na lupa depesquida no canto superior esquerdo")
	    public void e_clique_na_lupa_depesquida_no_canto_superior_esquerdo() {
	    	
	    }
	    
	    @Entao("devo validar a exibicao do formulario mobile")
	    public void entao_devo_validar_a_exibicao_do_formulario() {
	    	
	    }
}
