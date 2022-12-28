<%--
  Created by IntelliJ IDEA.
  User: Bráian Pereira
  Date: 27/12/2022
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<tags:layout>
    <div class="conteinerPrincipal">
        <h1 class="titulo">Pesquisa</h1>
        <form class="filtro" action="" method="post">
            <label for="filtro">Filtro: </label>
            <input class="barraPesquisa" placeholder="Teste" type="text" name="filtro" id="filtro">
            <input class="botaoFiltrar" type="submit" value="Filtrar">
        </form>
        <div class="containerTabela">
            <section>
                <button class="botaoTabela" type="button" name="inserir">Inserir</button>
                <button class="botaoTabela" type="button" name="atualizar">Atualizar</button>
                <button class="botaoTabela" type="button" name="excluir">Excluir</button>
            </section>
            <table>
                <thead id="aa">
                <tr>
                    <th>Selecação</th>
                    <th>col1</th>
                    <th>col2</th>
                    <th>col3</th>
                    <th>col4</th>
                    <th>col5</th>
                </tr>
                </thead>
                <tbody>
                <tr class="linha">
                    <td><input type="checkbox" name="selecao"></td>
                    <td>xxxxxxxx</td>
                    <td>xxxxxxxx</td>
                    <td>xxxxxxxx</td>
                    <td>xxxxxxxx</td>
                    <td>xxxxxxxx</td>
                </tr>
                <tr class="linha">
                    <td><input type="checkbox" name="selecao"></td>
                    <td>xxxxxxxx</td>
                    <td>xxxxxxxx</td>
                    <td>xxxxxxxx</td>
                    <td>xxxxxxxx</td>
                    <td>xxxxxxxx</td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="selecao"></td>
                    <td>xxxxxxxx</td>
                    <td>xxxxxxxx</td>
                    <td>xxxxxxxx</td>
                    <td>xxxxxxxx</td>
                    <td>xxxxxxxx</td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="selecao"></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</tags:layout>
