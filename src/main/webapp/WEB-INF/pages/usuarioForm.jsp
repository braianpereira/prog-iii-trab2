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
        <form action="${pageContext.request.contextPath}/usuarios/${method}" id="formUsuario" method="post">

            <div class="cadastro">
                <fieldset>
                    <legend>Dados de Identificações</legend>
                    <fieldset>
                        <label for="cpf">CPF: </label>
                        <input type="text" name="cpf" required id="cpf" onkeypress="validarCpf(event)" value="${usuario.getCpf()}">
                        <input type="hidden" name="pk" id="pk" value="${usuario.getCpf()}">
                    </fieldset>
                    <fieldset>
                        <label for="nome">Nome: </label>
                        <input type="text" name="nome" required id="nome" minlength="5" maxlength="100" value="${usuario.getNome()}">
                    </fieldset>
                    <fieldset>
                        <label for="nascimento">Data de Nascimento (dd/mm/yyyy): </label>
                        <input type="date" name="nascimento" id="nascimento" value="${usuario.getNascimento()}">
                    </fieldset>
                    <fieldset>
                        <label for="email">Email: </label>
                        <input type="email" name="email" required id="email" minlength="8" maxlength="45" value="${usuario.getEmail()}">
                    </fieldset>
                    <fieldset>
                        <input type="checkbox" name="whats" id="whats" <c:if test="${usuario.isWhats()}">checked</c:if>>
                        <label for="whats">É WhatsApp </label>
                        <label for="telefone">Telefone: </label>
                        <input type="text" name="telefone" id="telefone" value="${usuario.getTelefone()}">
                    </fieldset>
                    <fieldset>
                        <label for="username">Username: </label>
                        <input type="text" name="username" id="username"  required minlength="3" maxlength="15" value="${usuario.getUsername()}">
                    </fieldset>
                    <fieldset>
                        <label for="senha">Nova Senha: </label>
                        <input type="password" minlength="8" maxlength="255" <c:if test="${method == 'editar'}">required</c:if> name="senha" id="senha">
                    </fieldset>

                    <div class="botaoForm">
                        <button class="botaoTabela" type="submit" value="enviar">Salvar</button>
                        <a href="${pageContext.request.contextPath}/usuarios/"><input class="botaoTabela" type="button" value="Voltar"></a>
                    </div>
                </fieldset>
            </div>
        </form>
    </div>
</tags:layout>