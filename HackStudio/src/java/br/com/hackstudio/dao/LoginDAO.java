package br.com.hackstudio.dao;

//import br.com.hackstudio.model.Encriptador;
import br.com.hackstudio.model.Encriptador;
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

        try {
            String email = funcionario.getEmail();
            String password = funcionario.getPasswd(); //Não encriptado
            String sql = "SELECT * FROM funcionarios";

            Statement statement;
            ResultSet resultSet;
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                int estado = resultSet.getInt("estado");
                if(estado == 1){
                    String passDB = resultSet.getString("passwd"); //Encriptado
                    String emailDB = resultSet.getString("email");
                    String saltDB = resultSet.getString("salt");

                    boolean senhaOK = Encriptador.verifyUserPassword(password, passDB, saltDB);

                    if(email.equals(emailDB) && senhaOK){
                        funcionario.setId(resultSet.getInt("id"));
                        return "SUCESSO";

                    }
                }
                
            }
          
        } catch (Exception ex) {
            System.err.println("ex");
        }      
      
        return "Conta não lozalizada";

    }
}
