package br.com.hackstudio.dao;

import br.com.hackstudio.model.Tatuador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author witalo.sena
 */
public class TatuadorDAO implements Dao {
    private EntityManager em;

    @Override
    public boolean save(Object object) {

        Tatuador tat = (Tatuador) object;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("HackStudioPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(tat);
        entityManager.getTransaction().commit();
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

    /*
     @Override
     public List<Object> get() {
     // Instrução SQL para recuperar os registros
     String sql = "SELECT * FROM tatuador ORDER BY nome ASC;";

     // Lista para receber os registros recuperados
     List lstTatuadores = new ArrayList();

     try ( // Prepara a instrução SQL para ser enviada ao banco de dados
     PreparedStatement ps = conn.prepareStatement(sql);
     // Objeto que armazenará os dados recuperados (ResultSet)
     ResultSet rs = ps.executeQuery()) {

     while (rs.next()) {
     // Cria um objeto Pessoa
     Tatuador t = new Tatuador();

     // Atribui ao objeto Pessoa os valores retornados do banco
     t.setId(rs.getInt("id"));
     t.setNome(rs.getString("nome"));
     t.setEmail(rs.getString("email"));
     t.setEspecialidade(rs.getString("especialidade"));

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

     /*@Override
     public List<Object> get() 
     {
     EntityManagerFactory factory = Persistence.createEntityManagerFactory("HackStudioPU");
     EntityManager em = factory.createEntityManager();
     List<Tatuador> lstTatuador = em.createQuery("from tatuador").getResultList();
     return (List)lstTatuador;
     }*/
    @Override
<<<<<<< HEAD
    public  List<Object> get() {  
=======
    public List<Object> get() {
        // Instrução SQL para recuperar os registros
        String sql = "SELECT * FROM tatuadores ORDER BY nome ASC;";

        // Lista para receber os registros recuperados
        List lstTatuadores = new ArrayList();

        try ( // Prepara a instrução SQL para ser enviada ao banco de dados
                PreparedStatement ps = conn.prepareStatement(sql);
                // Objeto que armazenará os dados recuperados (ResultSet)
                ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                // Cria um objeto Pessoa
                Tatuador t = new Tatuador();

                // Atribui ao objeto Pessoa os valores retornados do banco
                t.setId(rs.getInt("id"));
                t.setNome(rs.getString("nome"));
                t.setEmail(rs.getString("email"));
                t.setEspecialidade(rs.getString("especialidade"));

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

    /*@Override
    public List<Object> get() 
    {
>>>>>>> 7a0049c93734bbb58b1e6eaa501cecf2520185aa
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("HackStudioPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        String jpql = "select t from Tatuador t";
        Query query = em.createQuery(jpql);
        em.clear();
        return null;
      
    }
}
