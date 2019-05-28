/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hackstudio.dao;

import br.com.hackstudio.model.Cliente;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
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
public class ClienteDao implements Dao {

    private final Connection conn;

    public ClienteDao() throws SQLException {
        // Recebe a conexão com o banco de dados
        this.conn = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean save(Object object) {
        Cliente cliente = (Cliente) object;
        String sql = "INSERT INTO clientes (nome, email, cpf, telefone, facebook, instagram) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            try (
                    PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, cliente.getNome());
                ps.setString(2, cliente.getEmail());
                ps.setString(3, cliente.getCpf());
                ps.setString(4, cliente.getTelefone());
                ps.setString(5, cliente.getFacebook());
                ps.setString(6, cliente.getInstagram());

                ps.execute();
            }
            conn.close();

            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Object object) {
        Cliente cliente = (Cliente) object;

        String sql = "UPDATE clientes SET nome = ?, telefone = ?, email = ?, cpf = ?, facebook = ?, instagram = ? WHERE id = ?;";

        try {
            try (
                PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, cliente.getNome());
                ps.setString(2, cliente.getTelefone());
                ps.setString(3, cliente.getEmail());
                ps.setString(4, cliente.getCpf());
                ps.setString(5, cliente.getFacebook());
                ps.setString(6, cliente.getInstagram());             
                ps.setLong(7, cliente.getId());
                ps.executeUpdate();
            }
  
            conn.close();
            return true;

        } catch (SQLException e) {
    
        }
        return false;

    }

    @Override
    public boolean delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(Long id) {

        try {
            String sql = "SELECT * FROM clientes WHERE id = ?";

            List listcli = new ArrayList();

            try (
                    PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setLong(1, id);

                try (
                        ResultSet rs = ps.executeQuery()) {

                    rs.next();

                    Cliente cliente = new Cliente();

                    cliente.setId(rs.getLong("id"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setTelefone(rs.getString("telefone"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setInstagram(rs.getString("instagram"));
                    cliente.setFacebook(rs.getString("facebook"));
                    listcli.add(cliente);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Fecha a conexão
            conn.close();

            // Retorna a lista com o registro solicitado
            return listcli;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public List<Object> get() {
        List<Object> lstcli = new ArrayList<>();

        try {
            String comando = "select * from clientes";
            PreparedStatement stmt = conn.prepareStatement(comando);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getLong("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                lstcli.add(cliente);
            }
            return lstcli;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }
        return null;

    }
}
