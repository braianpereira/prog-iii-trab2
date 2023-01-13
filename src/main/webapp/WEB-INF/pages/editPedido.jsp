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
<tags:layout><%--@elvariable id="method" type="java.lang.String"--%>
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
            <label for="Valor_Frete">Valor Frete:  </label>
            <input type="number" step=".01" name="Valor_Frete" required id="Valor_Frete" onkeypress="maskFrete(this)" onchange="updateTotal()" value="${pedidos.getValorFrete()}">
          </fieldset>
          <fieldset>
            <label for="Data_Entrega">Data de entrega :  </label>
            <input type="date" name="Data_Entrega" required id="Data_Entrega" value="${pedidos.getDataEntrega()}">
          </fieldset>
          <fieldset>
            <label for="">Cliente : </label>
            <span>${pedido.getCliente()}</span>
          </fieldset>
          <label>Produtos: </label>
          <button class="botaoTabela" type="button" onclick="addProduto()">&nbsp;&nbsp;&nbsp; + &nbsp;&nbsp; </button>
          <c:forEach var="pedidoProduto" items="${pedidoProdutos}">
            <div class="produtos">

                <span style="border: black solid 5px"> ${pedidoProduto.getProdutoId()} preco=${pedidoProduto.getPreco()} ${pedidoProduto.nomeProd()} R$ ${pedidoProduto.getPreco()} ${pedidoProduto.getUnidade()}</span>
                  <input type="number" onchange="updateTotal()" name="quantidade" min="1" value="1" style="max-width: 50px; margin-left: 15px">
                </select>
                <button type="button" class="botaoTabela" onclick="removeProduto(this)">Remover</button>

            </div>
          </c:forEach>
          <div class="produtos">
            <fieldset>
              <select name="produtos" onchange="updateTotal()">
                <c:forEach var="produto" items="${produtos}">
                  <option value="${produto.getId()}" preco="${produto.getPreco_unitario()}" >${produto.getNome()} R$ ${produto.getPrecoBr()} ${produto.getUnidade()}</option>
                </c:forEach>
                <input type="number" onchange="updateTotal()" name="quantidade" min="1" value="1" style="max-width: 50px; margin-left: 15px">
              </select>
              <button type="button" class="botaoTabela" onclick="removeProduto(this)">Remover</button>
            </fieldset>
          </div>

          <div>
            <p>TOTAL: R$ <span id="total">0,00</span></p>
          </div>

          <div class="botaoForm">
            <button class="botaoTabela" type="submit" value="enviar">Salvar</button>
            <a href="${request.getContextPath()}/clientes/"><input class="botaoTabela" type="button" value="Voltar"></a>
            <a href="${request.getContextPath()}/clientes/"><input class="botaoTabela" type="button" value="Voltar"></a>
          </div>
        </fieldset>
      </div>
    </form>
  </div>
</tags:layout>