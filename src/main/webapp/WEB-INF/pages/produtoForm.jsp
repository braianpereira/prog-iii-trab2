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
        <form action="${pageContext.request.contextPath}/produtos/${method}" method="post">

            <div class="cadastro">
                <fieldset>
                    <legend>Dados de Identificações</legend>
                    <input type="hidden" name="id" id="id" value="${produto.getId()}">
                    <fieldset>
                        <label for="nome">Nome: </label>
                        <input type="text" name="nome" required id="nome" maxlength="100" onkeypress="validarNomeProduto(event)" value="${produto.getNome()}">
                    </fieldset>
                    <fieldset>
                        <label for="descricao">Descrição:  </label>
                        <input type="text" name="descricao" required id="descricao" value="${produto.getDescricao()}">
                    </fieldset>
                    <fieldset>
                        <label for="unidade">Unidade:  </label>
                        <input type="text" name="unidade" required id="unidade" maxlength="3" onkeypress="validarUnidade(event)" value="${produto.getUnidade()}">
                    </fieldset>
                    <fieldset>
                        <label for="preco_unitario">Preço por unidade: </label>
                        <input type="text" name="preco_unitario" required id="preco_unitario" maxlength="3" onkeypress="validarNome(event)" value="${produto.getPreco_unitario()}">
                    </fieldset>
                    <div class="botaoForm">
                        <button class="botaoTabela" type="submit" value="enviar">Salvar</button>
                        <a href="${pageContext.request.contextPath}/clientes/"><input class="botaoTabela" type="button" value="Voltar"></a>
                    </div>
                </fieldset>
            </div>
        </form>
    </div>
</tags:layout>