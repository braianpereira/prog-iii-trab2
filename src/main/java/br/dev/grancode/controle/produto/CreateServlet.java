package br.dev.grancode.controle.produto;

import br.dev.grancode.dao.ProdutoDao;
import br.dev.grancode.modelo.Produto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CreateServlet", value = "/produtos/novo")
public class CreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Boolean logado = (Boolean) session.getAttribute("logado");

        if (logado != null && logado.equals(true)) {
            request.setAttribute("method", "novo");
            request.getRequestDispatcher("/WEB-INF/pages/produtoForm.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        HttpSession session = request.getSession();

        Boolean logado = (Boolean) session.getAttribute("logado");

        if (logado != null && logado.equals(true)) {
            try {
                String nome = request.getParameter("nome");
                String descricao = request.getParameter("descricao");
                String unidade = request.getParameter("unidade");
                float preco_unitario = Float.parseFloat(request.getParameter("preco_unitario"));


                Produto produto = new Produto();

                produto.setNome(nome);
                produto.setDescricao(descricao);
                produto.setUnidade(unidade);
                produto.setPreco_unitario(preco_unitario);

                int status = ProdutoDao.inserir(produto);
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
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }

    }
}
