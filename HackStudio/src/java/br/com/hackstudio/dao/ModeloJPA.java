/*package br.com.hackstudio.dao;

import br.com.animehire.model.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOCliente implements Dao {

    @Override
    public boolean save(Object object) {
        Cliente cli = (Cliente) object;
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AnimeHirePU");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(cli);
        em.getTransaction().commit();
        
        return true;
    }

    @Override
    public boolean update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        try{
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("AnimeHirePU");
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            Cliente p = em.find(Cliente.class, id);
            em.remove(p);
            em.getTransaction().commit();
            return true;
        }
        catch(Exception es){
           return false; 
        }
    }

    @Override
    public Object get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> get() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AnimeHirePU");
        EntityManager em = factory.createEntityManager();
        List<Cliente> lstCliente = em.createQuery("select c from Cliente c").getResultList();
        return (List)lstCliente;
    }
    
}*/