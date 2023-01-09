package br.dev.grancode.controle.usuario;

import br.dev.grancode.dao.UsuarioDao;
import br.dev.grancode.modelo.Usuario;
import com.mysql.cj.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "UsuarioServlet",
        urlPatterns = {"/usuarios/*", "/usuario/*"}
)
public class SelectServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        req.getRequestDispatcher("/WEB-INF/pages/usuarios.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Usuario> list = UsuarioDao.getAllUsuarios();

        request.setAttribute("usuarios", list);
        request.getRequestDispatcher("/WEB-INF/pages/usuarios.jsp").forward(request, response);
    }
}
