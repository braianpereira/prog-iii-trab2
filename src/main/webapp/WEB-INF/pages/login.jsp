<%--
  Created by IntelliJ IDEA.
  User: Bráian Pereira
  Date: 14/01/2023
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<tags:layout>
    <div class="conteinerPrincipal">
        <h1 class="titulo">Logar</h1>
        <form action="${pageContext.request.contextPath}/login" method="post">

            <div class="cadastro">
                <fieldset>
                    <legend>Dados de Identificações</legend>
                    <input type="hidden" name="id" id="id" value="${cliente.getId()}">
                    <fieldset>
                        <label for="username">Nome: </label>
                        <input type="text" name="username" required id="username" autocomplete="off">
                    </fieldset>
                    <fieldset>
                        <label for="senha">Senha: </label>
                        <input type="password" name="senha" required id="senha" autocomplete="false">
                    </fieldset>

                    <div class="botaoForm">
                        <button class="botaoTabela" type="submit" value="enviar">Entrar</button>
                    </div>
                </fieldset>
            </div>
        </form>
    </div>
<%--<script type="text/javascript">--%>
<%--    // Force safari to refresh the page--%>
<%--    // if a cached copy was loaded--%>
<%--    // from the browser back-forward cache.--%>
<%--    window.onpageshow = function(e) {--%>
<%--        if (e.persisted) {--%>
<%--            window.location.reload();--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>
</tags:layout>