package br.dev.grancode.controle.usuario;

import br.dev.grancode.dao.UsuarioDao;
import br.dev.grancode.modelo.Usuario;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;

@WebServlet(name = "UserCreateServlet", value = "/usuarios/novo")
public class CreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("method", "novo");
        req.getRequestDispatcher("/WEB-INF/pages/usuarioForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();


        try {
            String cpf = request.getParameter("cpf");
            String nome = request.getParameter("nome");
            String nascimento = request.getParameter("nascimento");
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");
            Boolean whats = (request.getParameter("whats") != null) && request.getParameter("whats").equals("on");
            String username = request.getParameter("username");
            String senha = request.getParameter("senha");

            Usuario usuario = new Usuario();

            usuario.setCpf(cpf);
            usuario.setNome(nome);

            usuario.setNascimento(nascimento);
            usuario.setEmail(email);
            usuario.setTelefone(telefone);
            usuario.setWhats(whats);
            usuario.setUsername(username);
            usuario.setSenha(senha);

            int status = UsuarioDao.inserir(usuario);
            out.print(status);
            if(status>0){
                out.print("<p>Record saved successfully!</p>");
                request.getRequestDispatcher("/WEB-INF/pages/usuarios.jsp").include(request, response);
                response.sendRedirect(request.getContextPath() + "/usuarios");
            }else{
                out.println("Sorry! unable to save record");
            }
        } catch (Exception e) {
            out.println("Sorry! unable to save record");
            e.printStackTrace();
        }

    }
}
