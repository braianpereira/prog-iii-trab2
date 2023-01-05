<%--
  Created by IntelliJ IDEA.
  User: Bráian Pereira
  Date: 27/12/2022
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<tags:layout>
    <div class="conteinerPrincipal">
        <h1 class="titulo">Cadastro</h1>
        <form action="${pageContext.request.contextPath}/usuarios/novo" method="post">
            <div class="cadastro">
                <fieldset>
                    <legend>Dados de Identificações</legend>
                    <fieldset>
                        <label for="cpf">CPF: </label>
                        <input type="text" name="cpf" id="cpf">
                    </fieldset>
                    <fieldset>
                        <label for="nome">Nome: </label>
                        <input type="text" name="nome" id="nome">
                    </fieldset>
                    <fieldset>
                        <label for="nascimento">Data de Nascimento (dd/mm/yyyy): </label>
                        <input type="date" name="nascimento" id="nascimento">
                    </fieldset>
                    <fieldset>
                        <label for="telefone">Email: </label>
                        <input type="email" name="email" id="email">
                    </fieldset>
                    <fieldset>
                        <input type="checkbox" name="whats" id="whats">
                        <label for="whats">É WhatsApp </label>
                        <label for="telefone">Telefone: </label>
                        <input type="text" name="telefone" id="telefone">
                    </fieldset>
                    <fieldset>
                        <label for="username">Username: </label>
                        <input type="text" name="username" id="username">
                    </fieldset>
                    <fieldset>
                        <label for="senha">Senha: </label>
                        <input type="password" name="senha" id="senha">
                    </fieldset>

                    <div class="botaoForm">
                        <button class="botaoTabela" type="submit" value="enviar">Salvar</button>
                        <a href="/usuarios/"><input class="botaoTabela" type="button" value="Voltar"></a>
                    </div>
                </fieldset>
            </div>
        </form>
    </div>
</tags:layout>