package br.dev.grancode.controle.usuario;

import br.dev.grancode.dao.UsuarioDao;
import br.dev.grancode.modelo.Usuario;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EditUserServlet", value = "/usuarios/editar")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpf=request.getParameter("cpf");

        try {
            Usuario usuario = UsuarioDao.getUsuarioPorCpf(cpf);

            String method = "editar";

            request.setAttribute("usuario", usuario);
            request.setAttribute("method", method);

            request.getRequestDispatcher("/WEB-INF/pages/usuarioForm.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();


        try {
            String oldCpf = request.getParameter("pk");
            String cpf = request.getParameter("cpf");
            String nome = request.getParameter("nome");
            String nascimento = request.getParameter("nascimento");
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");
            Boolean whats = (request.getParameter("whats") != null) && request.getParameter("whats").equals("on");
            String username = request.getParameter("username");
            String senha = request.getParameter("senha");

            Usuario usuario = UsuarioDao.getUsuarioPorCpf(oldCpf);

            usuario.setPk(oldCpf);
            usuario.setCpf(cpf);
            usuario.setNome(nome);

            usuario.setNascimento(nascimento);
            usuario.setEmail(email);
            usuario.setTelefone(telefone);
            usuario.setWhats(whats);
            usuario.setUsername(username);
            usuario.setSenha(senha);

            int status = UsuarioDao.atualizar(usuario);
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
