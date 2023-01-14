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
        <h1 class="titulo">Clientes</h1>

        <div class="containerTabela">
            <section>
                <button class="botaoTabela" type="button" name="inserir"><a href="${pageContext.request.contextPath}/clientes/novo">Inserir</a></button>
            </section>
            <table>
                <thead id="aa">
                <tr>
                    <th>Nome</th>
                    <th>Nascimento</th>
                    <th>Email</th>
                    <th>CPF</th>
                    <th>Ações</th>
                </tr>
                </thead>
                <tbody>
                <jsp:useBean id="clientes" scope="request" type="java.util.List"/>
                <c:forEach var="cliente" items="${clientes}">
                    <tr>
                        <td>${cliente.getNome()}</td>
                        <td>${cliente.getNascimentoBr()}</td>
                        <td>${cliente.getEmail()}</td>
                        <td>${cliente.getCpf()}</td>
                        <td>
                            <button class="botaoTabela" type="button" name="atualizar"><a href="${pageContext.request.contextPath}/clientes/editar?id=${cliente.getId()}">Atualizar</a></button>
                            <button class="botaoTabela" type="button" name="excluir"><a href="${pageContext.request.contextPath}/clientes/remover?id=${cliente.getId()}">Excluir</a></button>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</tags:layout>
