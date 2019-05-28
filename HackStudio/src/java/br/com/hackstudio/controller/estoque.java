/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hackstudio.controller;

import br.com.hackstudio.dao.EstoqueDAO;
import br.com.hackstudio.model.Estoque;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author witalo
 */
@WebServlet(name = "estoque", urlPatterns = {"/estoque"})
public class estoque extends HttpServlet {
     /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("acao").contains("editar")) {

            Estoque estoque = new Estoque();
            List listEstoque;            
            EstoqueDAO estoqueDAO = new EstoqueDAO();       
            estoque.setId(Long.parseLong(request.getParameter("id")));
            listEstoque = (List) estoqueDAO.get(estoque.getId());
            
            request.setAttribute("listEstoque", listEstoque);

            // Redireciona para a página de listagem 
            RequestDispatcher redireciona = request.getRequestDispatcher("updateEstoque.jsp");
            redireciona.forward(request, response);
        }

        //select all
        if (request.getParameter("acao").contains("todos")) {
            
            EstoqueDAO estoqueDAO = new EstoqueDAO();
            List listEstoque;          
            listEstoque = estoqueDAO.get();
            request.setAttribute("listEstoque", listEstoque);

            // Redireciona para a página de listagem 
            RequestDispatcher redireciona = request.getRequestDispatcher("estoque.jsp");
            redireciona.forward(request, response);
        }

        if (request.getParameter("acao").contains("agendamento")) {
            System.out.println("work");
        }

        if (request.getParameter("acao").contains("excluir")) {

           Estoque estoque = new Estoque();
            estoque.setId(Long.parseLong(request.getParameter("id")));

            EstoqueDAO estoqueDAO = new EstoqueDAO();
            estoqueDAO.delete(estoque.getId());

            response.setHeader("Refresh", "1; url=\"estoque?acao=todos\"");
            RequestDispatcher redireciona = request.getRequestDispatcher("index.jsp");
            redireciona.forward(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //create
        if (request.getParameter("acao").contains("cadastrar")) {

            Estoque estoque = new Estoque();

            estoque.setNome(request.getParameter("nome"));
            estoque.setQuantidade(request.getParameter("quantidade"));
            estoque.setValor_unitario(Double.parseDouble(request.getParameter("valor")));
            
            EstoqueDAO estoqueDAO = new EstoqueDAO(); 
            estoqueDAO.save(estoque);

            RequestDispatcher redireciona = request.getRequestDispatcher("index.jsp");
            redireciona.forward(request, response);
        }

        if (request.getParameter("acao").contains("alterar")) {

            Estoque estoque = new Estoque();
            estoque.setId(Long.parseLong(request.getParameter("id")));
            estoque.setNome(request.getParameter("nome"));
            estoque.setQuantidade(request.getParameter("quantidade"));
            estoque.setValor_unitario(Double.parseDouble(request.getParameter("valor")));
            EstoqueDAO estoqueDAO = new EstoqueDAO();
            estoqueDAO.update(estoque);
        
            response.setHeader("Refresh", "2; url=\"estoque?acao=todos\"");

            RequestDispatcher redireciona = request.getRequestDispatcher("index.jsp");
            redireciona.forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

   

}
