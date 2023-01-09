package br.dev.grancode.controle.cliente;

import br.dev.grancode.dao.UsuarioDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteClientServlet", value = "/clientes/remover")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpf=request.getParameter("cpf");

        UsuarioDao.excluir(cpf);
//        response.sendRedirect("SelectServlet");
        response.sendRedirect(request.getContextPath() + "/usuarios");

    }
}
