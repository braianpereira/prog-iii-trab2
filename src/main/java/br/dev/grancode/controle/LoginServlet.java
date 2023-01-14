package br.dev.grancode.controle;

import br.dev.grancode.modelo.Login;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();

            Boolean logado = (Boolean) session.getAttribute("logado");

            if (logado != null && logado.equals(true)) {
                response.sendRedirect(request.getContextPath() + "/");
            } else {
                request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String username = request.getParameter("username");
            String senha = request.getParameter("senha");

            Login login = new Login(username, senha);


            HttpSession session = request.getSession();

            session.setAttribute("logado", login.doLogin());

            if (session.getAttribute("logado").equals(true)) {
                response.sendRedirect(request.getContextPath() + "/");
            } else {
                response.sendRedirect(request.getContextPath() + "/login");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
