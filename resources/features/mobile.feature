# language: pt
# encoding: utf-8
Funcionalidade: Validar Pesquisa por lupa Dimencao navegador mobile

  @AbrirFormPesquisa @mobile
  Cenario: Abrir form pesquisa
    Dado que eu expanda o menu sandwich
    E pesquise no campo de de busca por "black" 
    Entao devo validar a tela de resultados