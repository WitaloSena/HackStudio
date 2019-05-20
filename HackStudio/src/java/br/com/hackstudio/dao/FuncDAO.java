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
    public String save(Funcionario funcionario){
        String sql = "INSERT INTO funcionarios (email, password) VALUES (?, ?)";

        try {
            try (
               PreparedStatement ps = conn.prepareStatement(sql)) {                
               ps.setString(1, funcionario.getEmail());
               ps.setString(2, funcionario.getPassword());              
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
        try {
            String comando = "delete from clientes where id = ?";

            PreparedStatement stmt = conn.prepareStatement(comando);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro: " + e);
            return false;

        }
    }

    @Override
    public Object get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   @Override
     public List<Object> get() {
     List<Object> lstFunc = new ArrayList<>();
        
     try
     {
     String comando = "select * from usuarios";
     PreparedStatement stmt = conn.prepareStatement(comando);
            
     ResultSet rs = stmt.executeQuery();
            
     while (rs.next())
     {
     Funcionario funcionario = new Funcionario();
     rs.getInt("id");
     rs.getString("username");
     rs.getInt("password");
                        
     lstFunc.add(funcionario);
     }
     return lstFunc;
     }
     catch (SQLException ex){
     System.err.println("Erro: " + ex);
     }
     return null;
     }

    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
