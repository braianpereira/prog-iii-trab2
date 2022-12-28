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
        <form action="" method="post">
            <div class="cadastro">
                <fieldset>
                    <legend>teste</legend>
                    <fieldset>
                        <label for="texto">texto: </label>
                        <input type="text" name="texto" id="texto">
                    </fieldset>
                    <fieldset>
                        <label for="selecao">seleção: </label>
                        <select name="selecao" id="selecao">
                            <option value="teste1">teste1</option>
                            <option value="teste2">teste2</option>
                            <option value="teste3">teste3</option>
                            <option value="teste4">teste4</option>
                        </select>
                    </fieldset>
                    <fieldset>
                        <label for="textarea">textarea: </label>
                        <textarea name="textarea" id="textarea" cols="30" rows="5"></textarea>
                    </fieldset>

                    <fieldset>
                        <label for="radio1">radio 1</label>
                        <input type="radio" name="radio" id="radio1">
                        <label for="radio2">radio 2</label>
                        <input type="radio" name="radio" id="radio2">
                    </fieldset>
                    <fieldset>
                        <label for="check1">checkbox 1</label>
                        <input type="checkbox" name="check" id="check1">
                        <label for="check2">checkbox 2</label>
                        <input type="checkbox" name="check" id="check2">
                        <label for="check3">checkbox 3</label>
                        <input type="checkbox" name="check" id="check3">
                    </fieldset>
                    <div class="botaoForm">
                        <a href="confirmacao.jsp"><input class="botaoTabela" type="button" value="enviar"></a>

                        <input class="botaoTabela" type="button" value="excluir">
                    </div>
                </fieldset>
            </div>
        </form>
    </div>
</tags:layout>