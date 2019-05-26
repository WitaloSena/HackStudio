package br.com.hackstudio.controller;

import br.com.hackstudio.dao.FuncDAO;
import br.com.hackstudio.model.Encriptador;
import br.com.hackstudio.model.Funcionario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class registrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("acao").contains("cadastrar")) {

            try {

                FuncDAO funcDAO = new FuncDAO();
                Funcionario funcionario = new Funcionario();

                String salt = Encriptador.getSalt(30);

                funcionario.setSalt(salt);

                funcionario.setNome(request.getParameter("nome"));
                funcionario.setSobrenome(request.getParameter("sobrenome"));
                funcionario.setEmail(request.getParameter("email"));
                funcionario.setPasswd(Encriptador.generateSecurePassword(request.getParameter("password"), salt));

                funcDAO.save(funcionario);
                //request.setAttribute("mensagem", result);
                RequestDispatcher redireciona = request.getRequestDispatcher("login.jsp");
                redireciona.forward(request, response);

            } catch (SQLException e) {
                if (e.getErrorCode() == 0) {
                    request.setAttribute("mensagem", "Não foi possível se comunicar com o banco de dados!");
                }
            }
        }
        RequestDispatcher redireciona = request.getRequestDispatcher("login.jsp");
        redireciona.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
