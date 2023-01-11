package br.dev.grancode.controle.produto;

import br.dev.grancode.dao.ProdutoDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/produtos/remover")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));

        ProdutoDao.excluir(id);
//        response.sendRedirect("SelectServlet");
        response.sendRedirect(request.getContextPath() + "/produtos");

    }

}
