package br.dev.grancode.controle.pedido;

import br.dev.grancode.dao.PedidoDao;
import br.dev.grancode.dao.PedidoProdutoDao;
import br.dev.grancode.modelo.Pedido;
import br.dev.grancode.modelo.PedidoProduto;
import br.dev.grancode.modelo.Produto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Edit_Servlet", value = "/pedidos/editar")
public class Edit_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numeroParam=request.getParameter("numero");
        int numero = Integer.parseInt(numeroParam);

        try {
            Pedido pedido = PedidoDao.getPedidoPorId(numero);
            List <PedidoProduto> list = PedidoProdutoDao.getAllPedidoProdutosPorId(numero);
            List <Produto>

            for (PedidoProduto p: list) {

            }

            String method = "editar";

            request.setAttribute("pedido", pedido);
            request.setAttribute("method", method);

            request.getRequestDispatcher("/WEB-INF/pages/pedidoForm.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
//
//        String[] produtos = request.getParameterValues("produtos");
//        String[] quantidades =request.getParameterValues("quantidade");
//

//        out.println("Selected Values...");
//        for(int i=0;i<produtos.length;i++)
//        {
//           out.println("<li>"+produtos[i]+ " - " +quantidades[i]+"</li>");
//        }
//        out.close();


        try {
            int numero = Integer.parseInt(request.getParameter("numero"));
            String dataEmissao = request.getParameter("Data_Emissao");
            float valorFrete = Float.parseFloat(request.getParameter("Valor_Frete"));
            String dataEntrega = request.getParameter("Data_Entrega");
            int clienteId = Integer.parseInt(request.getParameter("Cliente_Id"));

            String[] produtos = request.getParameterValues("produtos");
            String[] quantidades =request.getParameterValues("quantidade");

            Pedido pedido = new Pedido();

            pedido.setDataEmissao(dataEmissao);
            pedido.setValorFrete(valorFrete);
            pedido.setDataEntrega(dataEntrega);
            pedido.setCliente(clienteId);
            pedido.setProduto(produtos);
            pedido.setQuantidae(quantidades);

            int status = PedidoDao.inserir(pedido);
            out.print(status);
            if(status>0){
                out.print("<p>Record saved successfully!</p>");
                request.getRequestDispatcher("/WEB-INF/pages/pedidos.jsp").include(request, response);
                response.sendRedirect(request.getContextPath() + "/pedidos");
            }else{
                out.println("Sorry! unable to save record");
            }
        } catch (Exception e) {
            out.println("Sorry! unable to save record");
            e.printStackTrace();
        }
    }
}
