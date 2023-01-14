<%@ page import="br.dev.grancode.modelo.Pedido" %>
<%@ page import="br.dev.grancode.modelo.Produto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="br.dev.grancode.dao.ProdutoDao" %><%--
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
        <form action="${pageContext.request.contextPath}/clientes/${method}" id="formCliente" method="post">

            <div class="cadastro">
                <fieldset>
                    <legend>Dados de Identificações</legend>
                    <input type="hidden" name="id" id="id" value="${cliente.getId()}">
                    <fieldset>
                        <label for="nome">Nome: </label>
                        <input type="text" name="nome" required id="nome" value="${cliente.getNome()}">
                    </fieldset>
                    <fieldset>
                        <label for="nascimento">Data de Nascimento (dd/mm/yyyy): </label>
                        <input type="date" name="nascimento" required id="nascimento" value="${cliente.getNascimento()}">
                    </fieldset>
                    <fieldset>
                        <label for="cpf">CPF: </label>
                        <input type="text" name="cpf" required id="cpf" onkeypress="validarCpf(event)" value="${cliente.getCpf()}">
                    </fieldset>
                    <fieldset>
                        <label for="rg">RG: </label>
                        <input type="text" name="rg" required id="rg" maxlength="15"   value="${cliente.getRg()}">
                        <label for="orgao_emissor">Orgão emissor: </label>
                        <input type="text" name="orgao_emissor" required id="orgao_emissor" maxlength="20" onkeypress="validarOrgaoEmissor(event)"  value="${cliente.getOrgao_emissor()}">
                    </fieldset>
                    <fieldset>
                        <label for="email">Email: </label>
                        <input type="email" name="email" required id="email" maxlength="100" value="${cliente.getEmail()}">
                    </fieldset>
                    <fieldset>
                        <label for="telefone">Telefone: </label>
                        <input type="text" name="telefone" required id="telefone" maxlength="20"  value="${cliente.getTelefone()}">
                        <input type="checkbox" name="whats" id="whats" <c:if test="${cliente.isWhats()}">checked</c:if> >
                        <label for="whats">É WhatsApp </label>
                    </fieldset>
                    <fieldset>
                        <label for="logradouro">Rua: </label>
                        <input type="text" name="logradouro" id="logradouro" maxlength="100" required value="${cliente.getLogradouro()}">
                        <label for="numero">Nº: </label>
                        <input type="text" name="numero" id="numero"  required value="${cliente.getNumero()}">
                    </fieldset>
                    <fieldset>
                        <label for="bairro">Bairro: </label>
                        <input type="bairro" required name="bairro" id="bairro" maxlength="45" value="${cliente.getBairro()}">
                    </fieldset>
                    <fieldset>
                        <label for="cidade">Cidade: </label>
                        <input type="text" name="cidade" id="cidade" maxlength="45"  required value="${cliente.getCidade()}">
                        <label for="estado">Estado: </label>
                        <input type="text" name="estado" id="estado" maxlength="2" required value="${cliente.getEstado()}">
                    </fieldset>

                    <div class="botaoForm">
                        <input class="botaoTabela" name="submit" type="submit" value="enviar">
                        <a href="${request.getContextPath()}/clientes/"><input class="botaoTabela" type="button" value="Voltar"></a>
                    </div>
                </fieldset>
            </div>
        </form>
    </div>
</tags:layout>