package br.dev.grancode.controle.pedido;

import br.dev.grancode.dao.PedidoDao;
import br.dev.grancode.dao.ProdutoDao;
import br.dev.grancode.modelo.Pedido;
import br.dev.grancode.modelo.Produto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Select-Servlet", value = "/pedidos/*")
public class SelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pedido> list = PedidoDao.getAllPedidos();

        request.setAttribute("pedidos", list);
        request.getRequestDispatcher("/WEB-INF/pages/pedidos.jsp").forward(request, response);
    }
}
