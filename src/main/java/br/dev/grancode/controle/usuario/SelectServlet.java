package br.dev.grancode.controle.usuario;

import br.dev.grancode.dao.UsuarioDao;
import br.dev.grancode.modelo.Usuario;
import com.mysql.cj.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
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
//        request.getRequestDispatcher("/WEB-INF/pages/usuarios.jsp").forward(request, response);
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<a href='index.html'>Add New Employee</a>");
        out.println("<h1>Employees List</h1>");

        List<Usuario> list= UsuarioDao.getAllUsuarios();

//        out.print("<table border='1' width='100%'");
//        out.print("<tr><th>Name</th><th>Password</th><th>Email</th><th>CPF</th><th>Edit</th><th>Delete</th></tr>");
//        for(Usuario e:list){
//            out.print("<tr><td>"+e.getNome()+"</td><td>"
//                    +e.getSenha()+"</td><td>"+e.getEmail()+"</td><td>"+e.getCpf()
//                    +"</td><td><a href='EditUserServlet?cpf="+e.getCpf()
//                    +"'>edit</a></td> <td><a href='DeleteUserServlet?id="+e.getCpf()+"'>delete</a></td></tr>");
//        }
//        out.print("</table>");
//
//        out.close();
        HttpSession session=request.getSession();
        session.setAttribute("usuarios", list);
        request.setAttribute("usuarios", list);
        request.getRequestDispatcher("/WEB-INF/pages/usuarios.jsp").forward(request, response);
    }

    protected void doNew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/usuario-novo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
