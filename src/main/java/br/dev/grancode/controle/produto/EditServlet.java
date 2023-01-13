package br.dev.grancode.controle.produto;

import br.dev.grancode.dao.ProdutoDao;
import br.dev.grancode.modelo.Produto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EditServlet", value = "/produtos/editar")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam=request.getParameter("id");
        int id = Integer.parseInt(idParam);

        try {
            Produto produto = ProdutoDao.getProdutoPorId(id);

            String method = "editar";

            request.setAttribute("produto", produto);
            request.setAttribute("method", method);

            request.getRequestDispatcher("/WEB-INF/pages/produtoForm.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");
            String unidade = request.getParameter("unidade");
            float preco_unitario = Float.parseFloat(request.getParameter("preco_unitario"));

            Produto produto = ProdutoDao.getProdutoPorId(id);

            produto.setId(id);
            produto.setNome(nome);
            produto.setDescricao(descricao);
            produto.setUnidade(unidade);
            produto.setPreco_unitario(preco_unitario);

            int status = ProdutoDao.atualizar(produto);
            out.print(status);
            if(status>0){
                out.print("<p>Record saved successfully!</p>");
                request.getRequestDispatcher("/WEB-INF/pages/produtos.jsp").include(request, response);
                response.sendRedirect(request.getContextPath() + "/produtos");
            }else{
                out.println("Sorry! unable to save record");
            }
        } catch (Exception e) {
            out.println("Sorry! unable to save record");
            e.printStackTrace();
        }
    }
}
