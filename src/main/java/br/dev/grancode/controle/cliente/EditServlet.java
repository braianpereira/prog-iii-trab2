package br.dev.grancode.controle.cliente;

import br.dev.grancode.dao.ClienteDao;
import br.dev.grancode.dao.UsuarioDao;
import br.dev.grancode.modelo.Cliente;
import br.dev.grancode.modelo.Usuario;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EditClientServlet", value = "/clientes/editar")
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam=request.getParameter("id");
        int id = Integer.parseInt(idParam);

        try {
            Cliente cliente = ClienteDao.getClientePorId(id);

            String method = "editar";

            request.setAttribute("cliente", cliente);
            request.setAttribute("method", method);

            request.getRequestDispatcher("/WEB-INF/pages/clienteForm.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String nascimento = request.getParameter("nascimento");
            String cpf = request.getParameter("cpf");
            String rg = request.getParameter("rg");
            String orgao_emissor = request.getParameter("orgao_emissor");
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");
            Boolean whats = (request.getParameter("whats") != null) && request.getParameter("whats").equals("on");
            String logradouro = request.getParameter("logradouro");
            String numero = request.getParameter("numero");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");

            Cliente cliente = ClienteDao.getClientePorId(id);

            cliente.setId(id);
            cliente.setNome(nome);
            cliente.setNascimento(nascimento);
            cliente.setCpf(cpf);
            cliente.setRg(rg);
            cliente.setOrgao_emissor(orgao_emissor);
            cliente.setEmail(email);
            cliente.setTelefone(telefone);
            cliente.setWhats(whats);
            cliente.setLogradouro(logradouro);
            cliente.setNumero(numero);
            cliente.setBairro(bairro);
            cliente.setCidade(cidade);
            cliente.setEstado(estado);

            int status = ClienteDao.atualizar(cliente);
            out.print(status);
            if(status>0){
                out.print("<p>Record saved successfully!</p>");
                request.getRequestDispatcher("/WEB-INF/pages/clientes.jsp").include(request, response);
                response.sendRedirect(request.getContextPath() + "/clientes");
            }else{
                out.println("Sorry! unable to save record");
            }
        } catch (Exception e) {
            out.println("Sorry! unable to save record");
            e.printStackTrace();
        }
    }
}
