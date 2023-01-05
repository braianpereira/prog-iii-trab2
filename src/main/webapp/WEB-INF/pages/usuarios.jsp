<%@ page import="br.dev.grancode.modelo.Usuario" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Bráian Pereira
  Date: 27/12/2022
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<tags:layout>
    <div class="conteinerPrincipal">
        <h1 class="titulo">Usuários</h1>
        <form class="filtro" action="" method="post">
            <label for="filtro">Filtro: </label>
            <input class="barraPesquisa" placeholder="Teste" type="text" name="filtro" id="filtro">
            <input class="botaoFiltrar" type="submit" value="Filtrar">
        </form>
        <div class="containerTabela">
            <section>
                <button class="botaoTabela" type="button" name="inserir">Inserir</button>
                <button class="botaoTabela" type="button" name="atualizar">Atualizar</button>
                <button class="botaoTabela" type="button" name="excluir">Excluir</button>
            </section>
            <table>
                <thead id="aa">
                <tr>
                    <th>Nome</th>
                    <th>Nascimento</th>
                    <th>Email</th>
                    <th>Username</th>
                    <th>CPF</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${usuarios}">
                <tr>
                        <td>${product.getNome()}</td>
                        <td>${product.getNascimento()}</td>
                        <td>${product.getEmail()}</td>
                        <td>${product.getUsername()}</td>
                        <td>${product.getCpf()}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</tags:layout>
