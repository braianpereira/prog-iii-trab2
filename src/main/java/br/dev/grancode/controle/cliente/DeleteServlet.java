package br.dev.grancode.controle.cliente;

import br.dev.grancode.dao.UsuarioDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "DeleteClientServlet", value = "/clientes/remover")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Boolean logado = (Boolean) session.getAttribute("logado");

        if (logado != null && logado.equals(true)) {
            String cpf=request.getParameter("cpf");

            UsuarioDao.excluir(cpf);
            response.sendRedirect(request.getContextPath() + "/usuarios");
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
