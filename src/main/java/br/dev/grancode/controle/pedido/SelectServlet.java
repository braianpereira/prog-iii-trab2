package br.dev.grancode.controle.pedido;

import br.dev.grancode.dao.PedidoDao;
import br.dev.grancode.modelo.Pedido;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Select-Servlet", value = "/pedidos/*")
public class SelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Boolean logado = (Boolean) session.getAttribute("logado");

        if (logado != null && logado.equals(true)) {
            List<Pedido> list = PedidoDao.getAllPedidos();

            request.setAttribute("pedidos", list);
            request.getRequestDispatcher("/WEB-INF/pages/pedidos.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }

    }
}
