package br.com.hackstudio.dao;

import br.com.hackstudio.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.ConnectionFactory;

public class FuncDAO implements Dao {

    private final Connection conn;

    public FuncDAO() throws SQLException {
        // Recebe a conexão com o banco de dados
        this.conn = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean save(Object object){
        Funcionario funcionario = (Funcionario) object;
        
        String sql = "INSERT INTO funcionarios (nome, sobrenome, email, passwd, salt) VALUES (?, ?, ?, ?, ?)";
        
        String senha = funcionario.getPasswd();
        funcionario.setPasswd(senha);
        try {
            try (
               PreparedStatement ps = conn.prepareStatement(sql)) {                
               ps.setString(1, funcionario.getNome());
               ps.setString(2, funcionario.getSobrenome());
               ps.setString(3, funcionario.getEmail());
               ps.setString(4, funcionario.getPasswd());
               ps.setString(5, funcionario.getSalt());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Long id) {
        try {
            String comando = "delete from funcionarios where id = ?";

            PreparedStatement stmt = conn.prepareStatement(comando);
            stmt.setLong(1, id);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro: " + e);
            return false;

        }
    }
    @Override
    public Object get(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
     public List<Object> get() {
     List<Object> listFunc = new ArrayList<>();
        
     try
     {
        String comando = "select * from funcionarios";
        PreparedStatement stmt = conn.prepareStatement(comando);

        ResultSet rs = stmt.executeQuery();

        while (rs.next())
        {           
            Funcionario funcionario = new Funcionario();
            funcionario.setId(rs.getInt("id"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setSobrenome(rs.getString("sobrenome"));
            funcionario.setEmail(rs.getString("email"));
            funcionario.setPasswd(rs.getString("password"));
            funcionario.setSalt(rs.getString("salt"));
      
            listFunc.add(funcionario);
        }
        return listFunc;
     }
     catch (SQLException ex){
        System.err.println("Erro: " + ex);
     }
        return null;
     }

}
