package br.com.hackstudio.dao;

import br.com.hackstudio.model.Funcionario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utils.ConnectionFactory;

public class LoginDAO {

    private final Connection conn;

    public LoginDAO() throws SQLException {
        // Recebe a conexão com o banco de dados
        this.conn = ConnectionFactory.getInstance().getConnection();
    }
    
    public String autentifica(Funcionario funcionario) {

        String email = funcionario.getEmail();
        String password = funcionario.getPassword();
        String sql = "SELECT * FROM funcionarios";

        Statement statement;
        ResultSet resultSet;
        
        
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                String emailDB = resultSet.getString("email");
                String passDB = resultSet.getString("password");
                
                if(email.equals(emailDB) && password.equals(passDB)){
                    funcionario.setId(resultSet.getInt("id"));
                    
                    return "SUCESSO";
                }
                
            }
          
        } catch (Exception ex) {
            System.err.println("ex");
        }      
      
        return "Conta não lozalizada";

    }
}
