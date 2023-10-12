Algoritmo "Projeto Agência Voyage"

//NOME: Tailany Mariano Leite

//PROBLEMA PROPOSTO: Usando conceitos de programação estruturada (Vetor)
//criar em pseudocódigo um menu para simular um cadastro
//para uma agência de viagens com as seguintes funções
//cadastro de cliente e cadastro de destino, criar também
//uma consulta para cada estrutura de dados.
 
 
 
 //Resolução:.......

 Var

   Opcao: inteiro
   vetcliente: vetor [ 1..5] de caracter
   vetdestino: vetor [ 1..5] de caracter
   quantidadeElementos, i: inteiro
   quantidadeproduto, d: inteiro

procedimento adcliente ()
 Inicio
   escreval ("Registrar cliente")
   leia (vetcliente [quantidadeElementos])
   quantidadeElementos <- quantidadeElementos +1
Fimprocedimento

procedimento addestino ()
 Inicio
   escreval ("Registrar o destino")
   leia (vetdestino [quantidadeproduto])
   quantidadeproduto <- quantidadeproduto +1
Fimprocedimento

procedimento listarclientes ()
 Inicio
   escreval ("Listando clientes:")
   para i de 1 até quantidadeElementos -1 faca
      escreval("Cliente",i,":")
      escreval ("Nome: ",vetcliente[i])
   fimpara
Fimprocedimento

procedimento listardestino ()
 Inicio
   escreval ("Listando destino:")
   para d de 1 até quantidadeproduto -1 faca
      escreval("Destino",d,":")
      escreval("Destino:",vetdestino[d])
   fimpara
Fimprocedimento

Inicio
   escreval (" ============================= ")
   escreval (" BEM VINDO(A) A AGÊNCIA VOYAGE ")
   escreval (" ============================= ")

   quantidadeElementos <- 1
   quantidadeproduto <- 1
   enquanto Opcao <> 5  faca
      escreval( "-------------------------")
      escreval( "Digite o número da opção:")
      escreval( "-------------------------")
      escreval ("1.Registrar clientes")
      escreval ("2.Lista Clientes")
      escreval ("3.Registrar destino")
      escreval ("4.Listar destino")
      escreval ("5.Sair do menu")
      leia (Opcao)
      limpatela

      escolha Opcao
      caso 1
         se quantidadeElementos <= 5 entao
            adcliente ()
         senao
            escreval ("Não é possível acrescentar mais clientes")
         fimse

      caso 2
         se quantidadeElementos -1 > 0 entao
            listarclientes ()

         senao
            escreval (" Não há clientes cadastrados")
         fimse

         caso 3
         se quantidadeproduto <= 5 entao
            addestino ()
         senao
            escreval ("Não é possível acrescentar mais os destinos")
         fimse

      caso 4
         se quantidadeproduto -1 > 0 entao
            listardestino ()

         senao
            escreval (" Não há destinos cadastrados")
         fimse

      caso 5
         escreval ("Obrigado(a)!..Volte Sempre!")
      outrocaso
         escreval ("opção inválida")
      fimescolha

   fimenquanto

Fimalgoritmo



//Atenção: Todos os direitos reservados.