/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hackstudio.dao;

import br.com.hackstudio.model.Funcionario;
import br.com.hackstudio.model.Tatuador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnectionFactory;

/**
 *
 * @author witalo
 */
public class TatuadorDAO implements Dao {

    private final Connection conn;

    public TatuadorDAO() throws SQLException {
        // Recebe a conexão com o banco de dados
        this.conn = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public String save(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tatuador> listar() {

        // Instrução SQL para recuperar os registros
        String sql = "SELECT * FROM tatuadores ORDER BY nome ASC;";

        // Lista para receber os registros recuperados
        List lstTatuadores = new ArrayList();

        try ( // Prepara a instrução SQL para ser enviada ao banco de dados
                PreparedStatement ps = conn.prepareStatement(sql);
                // Objeto que armazenará os dados recuperados (ResultSet)
                ResultSet rs = ps.executeQuery()) {
            /**
             * Percorre os registros retornados do banco de dados e coloca em
             * uma lista (lstPessoas)
             */
            while (rs.next()) {
                // Cria um objeto Pessoa
                Tatuador t = new Tatuador();

                // Atribui ao objeto Pessoa os valores retornados do banco
                t.setId(rs.getInt("id"));
                t.setNome(rs.getString("nome"));
                t.setEmail(rs.getString("email"));

                // Adiciona o objeto Pessoa na lista de pessoas
                lstTatuadores.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TatuadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            // Fecha a conexão
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TatuadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Retorna a lista com as pessoas encontradas
        return lstTatuadores;
    }

    public List<Tatuador> getAllRecords() {
        
        String sql = "SELECT * FROM tatuadores";
        
        List<Tatuador> list = new ArrayList<>();

        try {
         
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tatuador t = new Tatuador();
                t.setId(rs.getInt("id"));
                t.setNome(rs.getString("nome"));
                t.setEmail(rs.getString("email"));
           
                list.add(t);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public List<Object> get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
