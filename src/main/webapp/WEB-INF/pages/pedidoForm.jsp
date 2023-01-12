<%@ page import="br.dev.grancode.modelo.Produto" %>
<%@ page import="java.util.List" %>
<%@ page import="br.dev.grancode.dao.ProdutoDao" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Bráian Pereira
  Date: 27/12/2022
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tags:layout>
    <div class="conteinerPrincipal">
        <h1 class="titulo">Cadastro</h1>
        <form action="${pageContext.request.contextPath}/pedidos/${method}" method="post">

            <div class="cadastro">
                <fieldset>
                    <legend>Dados de Identificações</legend>
                    <input type="hidden" name="id" id="id" value="${pedidos.getId()}">
                    <fieldset>
                        <label for="Data_Emissao">Data de Emissão: </label>
                        <input type="date" name="Data_Emissao" required id="Data_Emissao" value="${pedidos.getDataEmissao()}">
                    </fieldset>
                    <fieldset>
                        <label for="Valor_Frete">Descrição:  </label>
                        <input type="text" name="Valor_Frete" required id="Valor_Frete" value="${pedidos.getValorFrete()}">
                    </fieldset>
                    <fieldset>
                        <label for="Data_Entrega">Data de entrega :  </label>
                        <input type="date" name="Data_Entrega" required id="Data_Entrega" value="${pedidos.getDataEntrega()}">
                    </fieldset>
                    <fieldset>
                        <label for="Cliente_Id">Cliente : </label>
                        <select name="Cliente_Id" id="Cliente_Id">
                            <c:forEach var="cliente" items="${clientes}">
                                <option value="${cliente.getId()}">${cliente.getNome()}</option>
                            </c:forEach>
                        </select>
                    </fieldset>
                    <label for="produtos">Produtos: </label>
                    <fieldset class="produtos">
                        <select name="produtos" id="produtos">
                            <c:forEach var="produto" items="${produtos}">
                                <option value="${produto.getId()}">${produto.getNome()}</option>
                            </c:forEach>
                                <input type="number" name="quantidade">
                        </select>
                    </fieldset>

                    <fieldset class="produtos">
                        <select name="produtos" id="produtos">
                            <c:forEach var="produto" items="${produtos}">
                                <option value="${produto.getId()}">${produto.getNome()} UND:${produto.getUnidade()} R$:${produto.getPreco_unitario()}</option>

                            </c:forEach>
                                <li style="color: black; font-size: 12px; border: red solid 2px; padding: 5px">${produto.getUnidade()}</li>
                                <li style="color: black; font-size: 12px; border: red solid 2px; padding: 5px"></li>
                            <input type="number" name="quantidade">
                        </select>
                    </fieldset>
                    <div class="botaoForm">
                        <button class="botaoTabela" type="submit" value="enviar">Salvar</button>
                        <a href="${request.getContextPath()}/clientes/"><input class="botaoTabela" type="button" value="Voltar"></a>
                    </div>
                </fieldset>
            </div>
        </form>
    </div>
</tags:layout>