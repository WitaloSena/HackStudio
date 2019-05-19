package br.com.hackstudio.dao;

import br.com.hackstudio.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnectionFactory;

public class UsuarioDAO implements Dao {
    
    private final Connection conn;
    
       public UsuarioDAO() throws SQLException {
        // Recebe a conexão com o banco de dados
        this.conn = ConnectionFactory.getInstance().getConnection();
    }
    
    @Override
    public boolean save(Object object) {

        Usuario usuario = null;
        if (object instanceof Usuario) {
            usuario = (Usuario) object;
        } else {
            return false;
        }
        
        //nome, idade, sexo, cpf, endereço, telefone, email
        String comando = "insert into usuarios (username, password) values(?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(comando);
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
   
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        try{
            String comando = "delete from clientes where id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(comando);
            stmt.setInt(1,id);
            stmt.execute();
            return true;
        }
        catch (SQLException e){
            System.err.println("Erro: "+e);
            return false;
            
        }
    }

    @Override
    public Object get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> get() {
        List<Object> lstUsuarios = new ArrayList<>();
        
        try
        {
            String comando = "select * from clientes";
            PreparedStatement stmt = conn.prepareStatement(comando);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Usuario usu = new Usuario(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getInt("password"),
                        
                lstUsuarios.add(usu);
            }
            return lstUsuarios;
        }
        catch (SQLException ex){
            System.err.println("Erro: " + ex);
        }
        return null;
    }

}
