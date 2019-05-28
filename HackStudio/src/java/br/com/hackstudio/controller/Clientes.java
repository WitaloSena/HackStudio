package br.com.hackstudio.controller;

import br.com.hackstudio.dao.ClienteDao;
import br.com.hackstudio.model.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Clientes extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        // Verifica se o botão de cadastrar foi acionado
        if (request.getParameter("acao").contains("cadastrar")) {

            // Cria um objeto Pessoa
            Cliente cliente = new Cliente();

            // Atribui os valores do fomulário ao objeto criado
            cliente.setNome(request.getParameter("nome"));
            cliente.setEmail(request.getParameter("email"));
            cliente.setCpf(request.getParameter("cpf"));
            cliente.setTelefone(request.getParameter("telefone"));
            cliente.setFacebook(request.getParameter("facebook"));
            cliente.setInstagram(request.getParameter("instagram"));

            ClienteDao clienteDao = new ClienteDao();
            clienteDao.save(cliente);

            // Redireciona para a página de mensagem
            RequestDispatcher redireciona = request.getRequestDispatcher("index.jsp");
            redireciona.forward(request, response);
        }

        // Verifica se o botão Pesquisar foi acionado
        if (request.getParameter("acao").contains("pesquisar")) {
            /**
             * Cria o atributo mensagem utilizando o objeto request para enviar
             * para a página de mensagem caso não conecte no banco
             */
            // Redirecionar para uma saída (view)

            Cliente cliente = new Cliente();
            cliente.setNome("%" + request.getParameter("nome") + "%");
            ClienteDao clienteDao = new ClienteDao();
            List clientes = new ArrayList();
            if (clientes.isEmpty()) {
                // Criar um atributo mensagem para o objeto request
                request.setAttribute("mensagem", "Nenhuma ocorrência localizada!");

                // Redireciona para a página de mensagem
                RequestDispatcher redireciona = request.getRequestDispatcher("index.jsp");
                redireciona.forward(request, response);
            } else {
                // Criar um atributo para o objeto request
                request.setAttribute("listaClientes", clientes);

                // Redireciona para a página de mensagem
                RequestDispatcher redireciona = request.getRequestDispatcher("index.jsp");
                redireciona.forward(request, response);
            }
        }

        if (request.getParameter("acao").contains("excluir")) {

            Cliente cliente = new Cliente();
            cliente.setId(Long.parseLong(request.getParameter("id")));
            ClienteDao clienteDao = new ClienteDao();
            clienteDao.delete(cliente.getId());
            response.setHeader("Refresh", "5; url=\"clientes?acao=todos\"");
            RequestDispatcher redireciona = request.getRequestDispatcher("index.jsp");
            redireciona.forward(request, response);
        }

        // Verifica se o botão Alterar foi acionado
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("acao").contains("editar")) {

            try {
                Cliente cliente = new Cliente();

                cliente.setId(Long.parseLong(request.getParameter("id")));

                ClienteDao clienteDao = new ClienteDao();

                List listacli = new ArrayList();

                listacli = (List) clienteDao.get(cliente.getId());

                request.setAttribute("listacli", listacli);

                RequestDispatcher redireciona = request.getRequestDispatcher("updateCliente.jsp");
                redireciona.forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (request.getParameter("acao").contains("todos")) {

            try {

                ClienteDao clienteDao = new ClienteDao();

                List listacli = new ArrayList();

                listacli = clienteDao.get();

                if (listacli.isEmpty()) {

                    RequestDispatcher redireciona = request.getRequestDispatcher("index.jsp");
                    redireciona.forward(request, response);
                } else {
                    request.setAttribute("listacli", listacli);

                    RequestDispatcher redireciona = request.getRequestDispatcher("clientes.jsp");
                    redireciona.forward(request, response);
                }
            } catch (SQLException e) {
                if (e.getErrorCode() == 0) {

                    request.setAttribute("mensagem", "Não foi possível se comunicar com o banco de dados!");

                    RequestDispatcher redireciona = request.getRequestDispatcher("mensagem.jsp");
                    redireciona.forward(request, response);
                }
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("acao").contains("alterar")) {

            Cliente cliente = new Cliente();

            cliente.setId(Long.parseLong(request.getParameter("id")));
            cliente.setNome(request.getParameter("nome"));
            cliente.setEmail(request.getParameter("email"));
            cliente.setCpf(request.getParameter("cpf"));
            cliente.setTelefone(request.getParameter("telefone"));
            cliente.setInstagram(request.getParameter("instagram"));
            cliente.setFacebook(request.getParameter("facebook"));

            try {
                ClienteDao clienteDao = new ClienteDao();
                clienteDao.update(cliente);

            } catch (Exception e) {
            }

            response.setHeader("Refresh", "2; url=\"clientes?acao=todos\"");

        }

        if (request.getParameter("acao").contains("cadastrar")) {

            Cliente cliente = new Cliente();

            cliente.setNome(request.getParameter("nome"));
            cliente.setEmail(request.getParameter("email"));
            cliente.setCpf(request.getParameter("cpf"));
            cliente.setTelefone(request.getParameter("telefone"));
            cliente.setFacebook(request.getParameter("facebook"));
            cliente.setInstagram(request.getParameter("instagram"));

            try {
                ClienteDao clienteDao = new ClienteDao();
                clienteDao.save(cliente);
            } catch (SQLException e) {
                if (e.getErrorCode() == 0) {
                    request.setAttribute("mensagem", "Não foi possível se comunicar com o banco de dados!");
                }
            }
            RequestDispatcher redireciona = request.getRequestDispatcher("index.jsp");
            redireciona.forward(request, response);
        }
    }

}
