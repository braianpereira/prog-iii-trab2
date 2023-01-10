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

<tags:layout>
    <div class="conteinerPrincipal">
        <h1 class="titulo">Cadastro</h1>
        <form action="${pageContext.request.contextPath}/pedidos/${method}" method="post">

            <div class="cadastro">
                <fieldset>
                    <legend>Dados de Identificações</legend>
                    <input type="hidden" name="id" id="id" value="${pedidos.getId()}">
                    <fieldset>
                        <label for="dataEmissao">Nome: </label>
                        <input type="text" name="dataEmissao" required id="dataEmissao" value="${pedidos.getDataEmissao()}">
                    </fieldset>
                    <fieldset>
                        <label for="valorFrete">Descrição:  </label>
                        <input type="text" name="valorFrete" required id="valorFrete" value="${pedidos.getValorFrete()}">
                    </fieldset>
                    <fieldset>
                        <label for="dataEntrega">Data de entrega :  </label>
                        <input type="text" name="dataEntrega" required id="dataEntrega" value="${pedidos.getDataEntrega()}">
                    </fieldset>
                    <fieldset>
                        <label for="cliente">Cliente : </label>
                        <input type="text" name="cliente" required id="cliente" value="${pedidos.getCliente()}">
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