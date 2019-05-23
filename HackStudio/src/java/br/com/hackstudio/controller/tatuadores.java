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

        Tatuador t = new Tatuador();
        /*
         t.setNome(request.getParameter("nome"));
         t.setEmail(request.getParameter("email"));
         t.setCpf(request.getParameter("cpf"));
         t.setEndereco(request.getParameter("endereco"));
         t.setTelefone(request.getParameter("telefone"));
         t.setEspecialidade(request.getParameter("especialidade"));
         t.setFacebook(request.getParameter("facebook"));
         t.setInstagram(request.getParameter("instagram"));
         */
        t.setNome("jonh doe");
        t.setEmail("jonh@email.com");
        t.setCpf("12345678912");
        t.setEndereco("rua vegas");
        t.setTelefone("telefone");
        t.setEspecialidade("old School");
        t.setFacebook("facebook");
        t.setInstagram("instagram");

        TatuadorDAO tdi = new TatuadorDAO();
        tdi.save(t);

        RequestDispatcher redireciona = request.getRequestDispatcher("index.jsp");
        redireciona.forward(request, response);

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
        if (request.getParameter("acao").contains("cadastrar")) {

            Tatuador t = new Tatuador();
            /*
             t.setNome(request.getParameter("nome"));
             t.setEmail(request.getParameter("email"));
             t.setCpf(request.getParameter("cpf"));
             t.setEndereco(request.getParameter("endereco"));
             t.setTelefone(request.getParameter("telefone"));
             t.setEspecialidade(request.getParameter("especialidade"));
             t.setFacebook(request.getParameter("facebook"));
             t.setInstagram(request.getParameter("instagram"));
             */
            t.setNome("witalo");
            t.setEmail("witalo@email.com");
            t.setCpf("12345678912");
            t.setEndereco("rua candeias");
            t.setTelefone("telefone");
            t.setEspecialidade("old School");
            t.setFacebook("facebook");
            t.setInstagram("instagram");

            TatuadorDAO tdi = new TatuadorDAO();
            tdi.save(t);

            RequestDispatcher redireciona = request.getRequestDispatcher("index.jsp");
            redireciona.forward(request, response);
        }

        if (request.getParameter("acao").contains("todos")) {
            TatuadorDAO tatuadorDao = new TatuadorDAO();

            List listaTatuadores = new ArrayList();
            listaTatuadores = tatuadorDao.get();
            request.setAttribute("listaTatuadores", listaTatuadores);

            // Redireciona para a página de listagem 
            RequestDispatcher redireciona = request.getRequestDispatcher("mensagem.jsp");
            redireciona.forward(request, response);
        }
        
        if (request.getParameter("acao").contains("agendamento")){
            System.out.println("work");
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
