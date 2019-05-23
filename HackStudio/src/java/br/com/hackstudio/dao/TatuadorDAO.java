package br.com.hackstudio.dao;

import br.com.hackstudio.model.Tatuador;
import java.util.ArrayList;
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

    @Override
    public List<Object> get() {
        //List<Object> listaTatuador = new ArrayList<>();
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("HackStudioPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        String jpql = "select t from Tatuador t";
        Query query = entityManager.createQuery(jpql);

        List<Object> resultados = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();        
        
        return resultados;

     
    }
}
