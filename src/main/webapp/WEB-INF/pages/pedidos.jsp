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
        <h1 class="titulo">pedidos</h1>
            <%--        <form class="filtro" action="" method="post">--%>
            <%--            <label for="filtro">Filtro: </label>--%>
            <%--            <input class="barraPesquisa" placeholder="Teste" type="text" name="filtro" id="filtro">--%>
            <%--            <input class="botaoFiltrar" type="submit" value="Filtrar">--%>
            <%--        </form>--%>
        <div class="containerTabela">
            <section>
                <button class="botaoTabela" type="button" name="inserir"><a href="${pageContext.request.contextPath}/pedidos/novo">Inserir</a></button>
                    <%--                <button class="botaoTabela" type="button" name="atualizar">Atualizar</button>--%>
                    <%--                <button class="botaoTabela" type="button" name="excluir">Excluir</button>--%>
            </section>
            <table>
                <thead id="aa">
                <tr>
                    <th>Nemero do pedido</th>
                    <th>Cliente</th>
                    <th>Data de emissão</th>
                    <th>Valor do frete</th>
                    <th>Data de entrega</th>
                    <th>Valor Total</th>
                </tr>
                </thead>
                <tbody>
                <jsp:useBean id="pedidos" scope="request" type="java.util.List"/>
                <c:forEach var="pedido" items="${pedidos}">
                    <tr>
                        <td>${pedido.getNumero()}</td>
                        <td>${pedido.getClienteM().getNome()}</td>
                        <td>${pedido.getDataEmissaoPt()}</td>
                        <td>${pedido.getFreteString()}</td>
                        <td>${pedido.getDataEntregaPt()}</td>
                        <td>${pedido.getTotal()}</td>
                        <td>
                            <button class="botaoTabela" type="button" name="atualizar"><a href="${pageContext.request.contextPath}/pedidos/editar?numero=${pedido.getNumero()}">Atualizar</a></button>
                            <button class="botaoTabela" type="button" name="excluir"><a href="${pageContext.request.contextPath}/pedidos/remover?numero=${pedido.getNumero()}">Excluir</a></button>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</tags:layout>