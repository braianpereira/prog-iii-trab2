<%--
  Created by IntelliJ IDEA.
  User: Bráian Pereira
  Date: 27/12/2022
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<tags:layout>
    <div class="conteinerPrincipal">
    <h1 class="titulo">Clientes</h1>
        <%--        <form class="filtro" action="" method="post">--%>
        <%--            <label for="filtro">Filtro: </label>--%>
        <%--            <input class="barraPesquisa" placeholder="Teste" type="text" name="filtro" id="filtro">--%>
        <%--            <input class="botaoFiltrar" type="submit" value="Filtrar">--%>
        <%--        </form>--%>
    <div class="containerTabela">
        <section>
            <button class="botaoTabela" type="button" name="inserir"><a href="${pageContext.request.contextPath}/produtos/novo">Inserir</a></button>
                <%--                <button class="botaoTabela" type="button" name="atualizar">Atualizar</button>--%>
                <%--                <button class="botaoTabela" type="button" name="excluir">Excluir</button>--%>
        </section>
        <table>
            <thead id="aa">
            <tr>
                <th>Nome</th>
                <th>Nascimento</th>
                <th>Email</th>
                <th>CPF</th>
                <th>Ações</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="produto" items="${produtos}">
                <tr>
                    <td>${produto.getNome()}</td>
                    <td>${produto.getDescricao()}</td>
                    <td>${produto.getUnidade()}</td>
                    <td>${produto.getPreco_unitario()}</td>
                    <td>
                        <button class="botaoTabela" type="button" name="atualizar"><a href="${pageContext.request.contextPath}/produtos/editar?id=${produto.getId()}">Atualizar</a></button>
                        <button class="botaoTabela" type="button" name="excluir"><a href="${pageContext.request.contextPath}/produtos/remover?id=${produto.getId()}">Excluir</a></button>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>
</tags:layout>
