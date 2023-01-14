package br.dev.grancode.controle.cliente;

import br.dev.grancode.dao.ClienteDao;
import br.dev.grancode.modelo.Cliente;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectServlet", urlPatterns = {"/clientes/*"})
public class SelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Boolean logado = (Boolean) session.getAttribute("logado");

        if (logado != null && logado.equals(true)) {
            List<Cliente> list = ClienteDao.getAllClientes();

            request.setAttribute("clientes", list);
            request.getRequestDispatcher("/WEB-INF/pages/clientes.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
