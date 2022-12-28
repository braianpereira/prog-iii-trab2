<%@tag description="layout" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat+Alternates:wght@700&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>

    <link rel="stylesheet" href="style.css">
</head>

<body>
<header>
    <nav class="conteiner-nav">
        <div class="imgLogo">
            <img src="src/img.png" alt="Logo da escola">
        </div>
        <div class="conteiner-menu">
            <ul class="itens-menu" >
                <li><a href="index.jsp">&#8801Home</a></li>
                <li><a id="teste" href="pesquisa.jsp"> Pesquisar</a></li>
                <li><a href="cadastro.jsp">&#9998Cadastrar</a></li>
            </ul>
        </div>
    </nav>
</header>

<main>
    <jsp:doBody />
</main>


<footer>
    <div class="conteiner-footer">
            <span>
                Braian & Leonardo
            </span>
    </div>
</footer>
</body>
</html>