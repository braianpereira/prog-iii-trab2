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
    <h1 class="titulo">Produtos</h1>

    <div class="containerTabela">
        <section>
            <button class="botaoTabela" type="button" name="inserir"><a href="${pageContext.request.contextPath}/produtos/novo">Inserir</a></button>
        </section>
        <table>
            <thead id="aa">
            <tr>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Unidade</th>
                <th>Preço unitario</th>
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
