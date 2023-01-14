package br.dev.grancode.controle;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession session = request.getSession();
            session.setAttribute("logado", false);
        } catch (Exception e) {
            e.printStackTrace();
        }


        response.sendRedirect(request.getContextPath() + "/");
    }
}
