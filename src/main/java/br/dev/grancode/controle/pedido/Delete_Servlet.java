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
        int numero=Integer.parseInt(request.getParameter("numero"));

        PedidoDao.excluir(numero);
//        response.sendRedirect("SelectServlet");
        response.sendRedirect(request.getContextPath() + "/pedidos");

    }
}
