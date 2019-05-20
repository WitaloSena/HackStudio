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
    public List<Object> listar() {

        String sql = "SELECT * FROM tatuadores ORDER BY nome ASC";

        List lstTatuador = new ArrayList();

        try (
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Tatuador tatuador = new Tatuador();
                tatuador.setId(rs.getInt("id"));
                tatuador.setNome(rs.getString("nome"));
                tatuador.setEmail(rs.getString("email"));
                tatuador.setCpf(rs.getString("cpf"));
                tatuador.setEndereço(rs.getString("endereço"));
                tatuador.setTelefone(rs.getString("telefone"));
                tatuador.setFacebook(rs.getString("facebook"));
                tatuador.setInstagram(rs.getString("instagram"));
                tatuador.setEspecialidade(rs.getString("especialidade"));

                lstTatuador.add(tatuador);

            }
            conn.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return lstTatuador;

    }

    @Override
    public List<Object> get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
