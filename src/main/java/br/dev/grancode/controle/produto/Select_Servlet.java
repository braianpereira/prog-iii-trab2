package br.dev.grancode.controle.produto;

import br.dev.grancode.dao.ClienteDao;
import br.dev.grancode.dao.ProdutoDao;
import br.dev.grancode.modelo.Cliente;
import br.dev.grancode.modelo.Produto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Select_Servlet", value = "/produtos/*")
public class Select_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Produto> list = ProdutoDao.getAllProdutos();

        request.setAttribute("produto", list);
        request.getRequestDispatcher("/WEB-INF/pages/produtos.jsp").forward(request, response);
    }
}
