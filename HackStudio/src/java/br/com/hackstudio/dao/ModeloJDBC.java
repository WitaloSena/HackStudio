/*package br.com.hackstudio.dao;

import br.com.animehire.factory.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import br.com.animehire.model.Clientes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientesDAO implements Dao {
    
    @Override
    public boolean save(Object object) {

        Clientes usu = null;
        if (object instanceof Clientes) {
            usu = (Clientes) object;
        } else {
            return false;
        }
        
        //nome, idade, sexo, cpf, endereço, telefone, email
        String comando = "insert into clientes (nome, idade, sexo, cpf, endereco, telefone, email, usuario, senha, adm) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = ConnectionFactory.getConnetion().prepareStatement(comando);
            stmt.setString(1, usu.getNome());
            stmt.setInt(2, usu.getIdade());
            stmt.setString(3, usu.getSexo());
            stmt.setString(4, usu.getCpf());
            stmt.setString(5, usu.getEndereco());
            stmt.setString(6, usu.getTelefone());
            stmt.setString(7, usu.getEmail());
            stmt.setString(8, usu.getUsuario());
            stmt.setString(9, usu.getSenha());
            stmt.setString(10, usu.getAdmlevel());
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
            
            PreparedStatement stmt = ConnectionFactory.getConnetion().prepareStatement(comando);
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
            PreparedStatement stmt = new ConnectionFactory().getConnetion().prepareStatement(comando);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Clientes usu = new Clientes(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("sexo"),
                        rs.getString("cpf"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("usuario"),
                        rs.getString("senha"),
                        rs.getString("adm"));
                lstUsuarios.add(usu);
            }
            return lstUsuarios;
        }
        catch (SQLException ex){
            System.err.println("Erro: " + ex);
        }
        return null;
    }

}*/