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
        HttpSession session = request.getSession();

        Boolean logado = (Boolean) session.getAttribute("logado");

        if (logado != null && logado.equals(true)) {
            int id=Integer.parseInt(request.getParameter("id"));

            ProdutoDao.excluir(id);

            response.sendRedirect(request.getContextPath() + "/produtos");

        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }

    }

}
