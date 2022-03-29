# language: pt
# encoding: utf-8
Funcionalidade: Validar Pesquisa por lupa Dimencao navegador mobile

  @AbrirFormPesquisa @mobile
  Cenario: Abrir form pesquisa
    Dado que esteja na tela inicial
    E clique na lupa depesquida no canto superior esquerdo
    Entao devo validar a exibicao do formulario mobile