package br.dev.grancode.controle.pedido;

import br.dev.grancode.dao.PedidoDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Delete_Servlet", value = "/pedidos/remover")
public class Delete_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Boolean logado = (Boolean) session.getAttribute("logado");

        if (logado != null && logado.equals(true)) {
            int numero=Integer.parseInt(request.getParameter("numero"));

            PedidoDao.excluir(numero);

            response.sendRedirect(request.getContextPath() + "/pedidos");
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
