<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="Imagem/Agencia_Voya__favicon.png" type="image/x-icon">
    <title>Novo Destino</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
    body {
            background-image: url('Imagem/oceano.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }

        .container {
            background-color: rgba(255, 255, 255, 0.8);
            padding: 20px;
            border-radius: 10px;
            margin-top: 20px;
        }
/* Imagem de fundo*/

  /* Centralizar texto e deixar laterais retas */
  main {
        padding: 20px;
        text-align: justify;
        background-image: url("Imagem/oceano.jpg");
        background-size: cover;
    }

    .centered-content {
        width: 80%; /* Definir a largura máxima do conteúdo centralizado */
        margin: 0 auto; /* Centralizar horizontalmente */
    }

    .vertical-center {
        display: flex;
        align-items: center;
        justify-content: center;
        height: 100vh;
    } 

    .justify-text {
        text-align: justify;
    }




#acesso {
    color: #ffffff;
    height: 28px;
    font-size: 15px;
   
}

small .p {
    font-size: 12px; /* Diminuir o tamanho da fonte do texto dentro do elemento <small>*/
}

p {
    font-size: 18px; /* Aumentar o tamanho da fonte do parágrafo */
}

main {
    flex-grow: 1;
    color: white;
    
}


/* Barra de navegação */
.bg-menu {
    background-image: url('Imagem/oceano.jpg'); /* Defina o caminho da imagem de fundo */
    background-size: cover; /* Define como a imagem de fundo será dimensionada */
    background-repeat: no-repeat; /* Evita a repetição da imagem de fundo */
    background-attachment: fixed; /* Fixa a imagem de fundo, para que ela não role com a página */
    
    
}


.navbar-nav .nav-link {
    color: white;
    letter-spacing: 2px; /* Espaçamento entre as letras */
    font-size: 18px; /* Tamanho da fonte */
    margin-right: 70px; /* Aumento do espaçamento entre as frases */
    transition: color 0.3s; /* Efeito de transição suave na mudança de cor */
}

.navbar-nav .nav-link:hover {
    color: #ff07ff; /* Cor do link ao passar o mouse */
}

.costum-margem {
    margin-top: 150px;
    margin-left: 12px;
    margin-right: 12px;
}



.custom-img {
    max-width: 100%;
    min-height: 100%;
}
/* Página cadastro */



/* Rodapé */
footer {
    
    background-image: url('Imagem/oceano.jpg'); /* Defina o caminho da imagem de fundo */
    background-size: cover; /* Define como a imagem de fundo será dimensionada */
    background-repeat: no-repeat; /* Evita a repetição da imagem de fundo */
    background-attachment: fixed; /* Fixa a imagem de fundo, para que ela não role com a página */
    padding: 15px 0 0;
    bottom: 0;
    font-size: 12px;
    color: white;
}

.style-list {
    list-style: none;
    padding-left: 0px;
}

.style-list li {
    padding-bottom: 4px;
}

        
    </style>
    
</head>
<body>
<header>
        <nav class="navbar navbar-expand-md bg-menu">
            <div class="container-fluid">
                <a class="navbar-brand">
                    <img src="Imagem/Voya-preview.png" width="200" height="81"  class="d-inline-block align-text-top">
                    </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
                    <div class="navbar-nav ps-1 d-flex mx-auto">
                        <a class="nav-link" href="./">Home</a>
                        <a class="nav-link" href="./destino">Destino</a>
                        <a class="nav-link" href="./promocao">Promoções</a>
                        <a class="nav-link" href="./usuario">Usuarios</a>
                        


                    </div>
                </div>
            </div>
            
        </nav>
    </header>
    <!-- Barra de navegação [Fim] -->

<div class="container">
    <h1>Tabela de Destino</h1>
    <table class="table table-bordered">
        <thead>
            <tr>
                
                
                <th>Data de ida</th>
                <th>Data de volta</th>
                <th>Destino da viagem</th>
                <th>Formas de pagamento</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            
            <jstl:forEach items="${listadestino}" var="l">
					<tr>
						<td>${l.data_de_ida}</td>
						<td>${l.data_de_volta}</td>
						<td>${l.destino_da_viagem}</td>
						<td>${l.formas_de_pagamento}</td>
					<td>	
						<a href="destino-edit?id=${l.id_destino }" class="btn btn-success">Editar</a> 
						<a href="destino-delete?id=${l.id_destino }" class="btn btn-danger">Deletar</a>
						
					</td>
				</jstl:forEach>
			</tbody>
		</table>
		<a href="views/destino/createdestino.jsp" class="btn btn-primary">Criar</a>
	</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

