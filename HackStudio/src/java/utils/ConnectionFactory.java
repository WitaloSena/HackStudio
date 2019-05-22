
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Object getConnetion() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    // variáveis para a conexão
    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/hackstudio_db";
    private final String usuario = "root";
    private final String senha = "";
    private static ConnectionFactory connectionFactory = null;

    private ConnectionFactory() throws SQLException {
        try {
            // Configura o driver para a conexão
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new SQLException("driver não encontrado");
        }
    }


    public Connection getConnection() throws SQLException {
        // Variável para receber a conexão
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            throw new SQLException(String.valueOf(e.getMessage()));
        }

        // Retorna uma conexão caso ocorra sucesso
        return conn;
    }


    public static ConnectionFactory getInstance() throws SQLException {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }
}
