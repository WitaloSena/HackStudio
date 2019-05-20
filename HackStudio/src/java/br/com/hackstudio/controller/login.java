package br.com.hackstudio.controller;

import br.com.hackstudio.dao.LoginDAO;
import br.com.hackstudio.model.Funcionario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet {

    public login() {
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("acao").contains("login")) {

            try {
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                
                Funcionario funcionario = new Funcionario();
                
                funcionario.setEmail(email);
                funcionario.setPassword(password);
                
                LoginDAO loginDAO = new LoginDAO();
                String Validate = loginDAO.autentifica(funcionario);
                
                if (Validate.equals("SUCESSO")) {
                    request.setAttribute("email", email);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    request.setAttribute("erro", Validate);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
