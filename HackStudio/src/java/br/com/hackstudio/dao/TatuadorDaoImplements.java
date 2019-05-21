/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hackstudio.dao;

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
public class TatuadorDaoImplements implements TatuadorDAO {

    private final Connection conn;

    public TatuadorDaoImplements() throws SQLException {
        // Recebe a conexão com o banco de dados
        this.conn = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public String save(Tatuador t) {
        String sql = "INSERT INTO tatuadores (nome, email, cpf, endereco, telefone, especialidade, facebook, instagram) VALUES (?,?,?,?,?,?,?,?)";
 
        try {
            try (
                PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, t.getNome());
                ps.setString(1, t.getEmail());
                ps.setString(1, t.getEmail());
                ps.setString(1, t.getCpf());
                ps.setString(1, t.getEndereço());
                ps.setString(1, t.getTelefone());
                ps.setString(1, t.getEspecialidade());
                ps.setString(1, t.getFacebook());
                ps.setString(1, t.getInstagram());
              
                ps.execute();
            }
            conn.close();

            return "Usuario salvo com sucesso";

        } catch (SQLException e) {
            return e.getMessage();
        }
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
        List<Tatuador> tatuadors = new ArrayList<>();

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

                t.setId(rs.getInt("id"));
                t.setNome(rs.getString("nome"));
                t.setEmail(rs.getString("email"));
                t.setEspecialidade(rs.getString("especialidade"));

                tatuadors.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TatuadorDaoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            // Fecha a conexão
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TatuadorDaoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Retorna a lista com as pessoas encontradas
        return tatuadors;
    }
}
