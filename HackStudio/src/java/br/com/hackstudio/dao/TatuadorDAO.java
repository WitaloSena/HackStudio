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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
    public boolean save(Object object) {
        Tatuador tat = (Tatuador) object;
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AnimeHirePU");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(tat);
        em.getTransaction().commit();
        
        return true;
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
    public List<Object> get() {

        // Instrução SQL para recuperar os registros
        String sql = "SELECT * FROM tatuadores ORDER BY nome ASC;";

        // Lista para receber os registros recuperados
        List lstTatuadores = new ArrayList();

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

                // Atribui ao objeto Pessoa os valores retornados do banco
                t.setId(rs.getInt("id"));
                t.setNome(rs.getString("nome"));
                t.setEmail(rs.getString("email"));

                // Adiciona o objeto Pessoa na lista de pessoas
                lstTatuadores.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TatuadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            // Fecha a conexão
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TatuadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Retorna a lista com as pessoas encontradas
        return lstTatuadores;
    }

    /*public List<Tatuador> getAllRecords() {
        
        String sql = "SELECT * FROM tatuadores";
        
        List<Tatuador> list = new ArrayList<>();

        try {
         
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tatuador t = new Tatuador();
                t.setId(rs.getInt("id"));
                t.setNome(rs.getString("nome"));
                t.setEmail(rs.getString("email"));
           
                list.add(t);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }*/

    /*@Override
    public List<Object> get() 
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("HackStudio");
        EntityManager em = factory.createEntityManager();
        List<Tatuador> lstTatuador = em.createQuery("select c from Cliente c").getResultList();
        return (List)lstTatuador;
    }*/
}
