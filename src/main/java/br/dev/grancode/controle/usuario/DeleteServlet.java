package br.dev.grancode.controle.usuario;

import br.dev.grancode.dao.UsuarioDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteUserServlet", value = "/usuarios/remover")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpf=request.getParameter("cpf");

        UsuarioDao.excluir(cpf);
        response.sendRedirect("SelectServlet");

    }
}
