package br.com.hackstudio.controller;

import br.com.hackstudio.dao.TatuadorDAO;
import br.com.hackstudio.model.Tatuador;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class tatuadores extends HttpServlet {

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
            
            Tatuador tatuador = new Tatuador();
            
            tatuador.setId(Long.parseLong(request.getParameter("id")));
            
            TatuadorDAO tatuadorDao = new TatuadorDAO();         

            // Redireciona para a página de listagem 
            RequestDispatcher redireciona = request.getRequestDispatcher("update.jsp");
            redireciona.forward(request, response);
        }

        //select all
        if (request.getParameter("acao").contains("todos")) {
            TatuadorDAO tatuadorDao = new TatuadorDAO();

            List listaTatuadores = new ArrayList();
            listaTatuadores = tatuadorDao.get();
            request.setAttribute("listaTatuadores", listaTatuadores);

            // Redireciona para a página de listagem 
            RequestDispatcher redireciona = request.getRequestDispatcher("tatuadores.jsp");
            redireciona.forward(request, response);
        }

        if (request.getParameter("acao").contains("agendamento")) {
            System.out.println("work");
        }

        if (request.getParameter("acao").contains("excluir")) {

            Tatuador tatuador = new Tatuador();

            tatuador.setId(Long.parseLong(request.getParameter("id")));

            TatuadorDAO tatuadorDAO = new TatuadorDAO();
            tatuadorDAO.delete(tatuador.getId());

            response.setHeader("Refresh", "1; url=\"tatuadores?acao=todos\"");
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

            Tatuador tatuador = new Tatuador();

            tatuador.setNome(request.getParameter("nome"));
            tatuador.setEmail(request.getParameter("email"));
            tatuador.setCpf(request.getParameter("cpf"));
            tatuador.setEndereco(request.getParameter("endereco"));
            tatuador.setTelefone(request.getParameter("telefone"));
            tatuador.setEspecialidade(request.getParameter("especialidade"));
            tatuador.setFacebook(request.getParameter("facebook"));
            tatuador.setInstagram(request.getParameter("instagram"));

            TatuadorDAO tdi = new TatuadorDAO();
            tdi.save(tatuador);

            RequestDispatcher redireciona = request.getRequestDispatcher("index.jsp");
            redireciona.forward(request, response);
        }

        if (request.getParameter("acao").contains("alterar")) {
    
            Tatuador tatuador = new Tatuador();
            tatuador.setNome(request.getParameter("nome"));
            tatuador.setEmail(request.getParameter("email"));
            tatuador.setCpf(request.getParameter("cpf"));
            tatuador.setEndereco(request.getParameter("endereco"));
            tatuador.setTelefone(request.getParameter("telefone"));
            tatuador.setEspecialidade(request.getParameter("especialidade"));
            tatuador.setFacebook(request.getParameter("facebook"));
            tatuador.setInstagram(request.getParameter("instagram"));
            
            TatuadorDAO tatuadorDAO = new TatuadorDAO();
            tatuadorDAO.update(tatuador);
            response.setHeader("Refresh", "2; url=\"tatuadores?acao=todos\"");
        
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
