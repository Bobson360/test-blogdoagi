# language: pt
# encoding: utf-8
Funcionalidade: Validar Pesquisa por lupa Dimencao navegador computador

  @AbrirFormPesquisa @web
  Cenario: Abrir form pesquisa
    Dado clique na lupa de pesquida no canto superior esquerdo
    Entao devo validar a exibicao do formulario

  @FecharFormPesquisa @web
  Cenario: Fechar form pesquisa
    Dado clique na lupa de pesquida no canto superior esquerdo
    Entao devo validar o fechamento do formulario

  @placeholder @web
  Cenario: Validar placeholder
    Dado clique na lupa de pesquida no canto superior esquerdo
    Entao devo validar o placeholder do form de pesquisa

  @BtnPesquisar @web
  Cenario: Pesquisar pelo btn pesquisar
    Dado clique na lupa de pesquida no canto superior esquerdo
    E digitar no campo de pesquisa o texto "black"
    E clicar no botao pesquisar
    Entao devo validar a tela de resultados

  @PressEnter @web
  Cenario: Pesquisar precionando enter
    Dado clique na lupa de pesquida no canto superior esquerdo
    E digitar no campo de pesquisa o texto "black"
    E precionar a tecla enter
    Entao devo validar a tela de resultados

  @NoResults @web
  Cenario: Nenhum resultado encontrado
    Dado clique na lupa de pesquida no canto superior esquerdo
    E digitar no campo de pesquisa o texto "ddxf"
    E clicar no botao pesquisar
    Entao validar a tela de nenhum resultado encontrado

  @FieldSearchNoResults @web 
  Cenario: Campo de pesquisa nenhum resultado encontrado
    Dado clique na lupa de pesquida no canto superior esquerdo
    E digitar no campo de pesquisa o texto "ddxf"
    E clicar no botao pesquisar
    Entao o campo de pesquisa com o mesmo texto buscado "ddxf"

  @FieldSearchNoResultsReflect @web @test
  Cenario: Pesquisa nenhum resultado encontrado reflete no value da pesquisa da lupa
    Dado clique na lupa de pesquida no canto superior esquerdo
    E digitar no campo de pesquisa o texto "ddxf"
    E clicar no botao pesquisar
    E pesquisar pelo campo de pesquisa da tela sem resultados o texto "ghtdk"
    Quando clique na lupa de pesquida no canto superior esquerdo
    Entao o valor na caixa de pesquisa deve ser covespondente a "ghtdk"
