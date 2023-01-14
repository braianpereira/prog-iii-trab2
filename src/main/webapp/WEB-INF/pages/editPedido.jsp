<%--
  Created by IntelliJ IDEA.
  User: Bráian Pereira
  Date: 27/12/2022
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tags:layout><jsp:useBean id="pedido" scope="request" type="br.dev.grancode.modelo.Pedido"/>
<%--@elvariable id="method" type="java.lang.String"--%>
  <div class="conteinerPrincipal">
    <h1 class="titulo">Cadastro</h1>
    <form action="${pageContext.request.contextPath}/pedidos/${method}" method="post">

      <div class="cadastro">
        <fieldset>
          <legend>Dados de Identificações</legend>
          <input type="hidden" name="numero" id="numero" value="${pedido.getNumero()}">
          <fieldset>
            <label for="Data_Emissao">Data de Emissão: </label>
            <input type="date" name="Data_Emissao" required id="Data_Emissao" value="${pedido.getDataEmissao()}">
          </fieldset>
          <fieldset>
            <label for="Valor_Frete">Valor Frete:  </label>
            <input type="number" step=".01" name="Valor_Frete" min="0" required id="Valor_Frete" onchange="updateTotal()" value="${pedido.getValorFrete()}">
          </fieldset>
          <fieldset>
            <label for="Data_Entrega">Data de entrega :  </label>
            <input type="date" name="Data_Entrega" required id="Data_Entrega" value="${pedido.getDataEntrega()}">
          </fieldset>
          <fieldset>
            <label>Cliente : </label>
            <select name="Cliente_Id" id="Cliente_Id">
              <c:forEach var="cliente" items="${clientes}">
                <option value="${cliente.getId()}" <c:if test="${cliente.getId() == pedido.getCliente() }">selected</c:if> >${cliente.getNome()}</option>
              </c:forEach>
            </select>
          </fieldset>
          <label>Produtos: </label>
          <button class="botaoTabela" type="button" onclick="addProduto()">&nbsp;&nbsp;&nbsp; + &nbsp;&nbsp; </button>
          <c:forEach var="pedidoProduto" items="${pedidoProdutos}">
            <div class="produtos">
              <fieldset>
                <select name="produtos" onchange="updateTotal()">
                  <jsp:useBean id="produtos" scope="request" type="java.util.List"/>
                  <c:forEach var="produto" items="${produtos}">
                    <option value="${produto.getId()}"
                            preco="${produto.getPreco_unitario()}"
                            <c:if test="${produto.getId() == pedidoProduto.getProdutoId()}">selected</c:if>
                    >${produto.getNome()} R$ ${produto.getPrecoBr()} ${produto.getUnidade()}</option>
                  </c:forEach>
                  <input type="number" onchange="updateTotal()" name="quantidade" min="1" value="${pedidoProduto.getQuantidade()}" style="max-width: 50px; margin-left: 15px">
                </select>
                <button type="button" class="botaoTabela" onclick="removeProduto(this)">Remover</button>
              </fieldset>
            </div>
          </c:forEach>

          <div>
            <p>TOTAL: <span id="total">${pedido.getTotal()}</span></p>
          </div>

          <div class="botaoForm">
            <button class="botaoTabela" type="submit" value="enviar">Salvar</button>
            <a href="${pageContext.request.contextPath}/pedidos/"><input class="botaoTabela" type="button" value="Voltar"></a>
          </div>
        </fieldset>
      </div>
    </form>
  </div>
</tags:layout>