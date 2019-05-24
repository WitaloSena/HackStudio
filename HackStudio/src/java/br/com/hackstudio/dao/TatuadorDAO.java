package br.com.hackstudio.dao;

import br.com.hackstudio.model.Tatuador;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TatuadorDAO implements Dao {
    
    @Override
    public boolean save(Object object) {

        Tatuador tatuador = (Tatuador) object;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("HackStudioPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        
        entityManager.persist(tatuador);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
        return true;
    }

    @Override
    public boolean update(Object object) {

        Tatuador tatuador = (Tatuador) object;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("HackStudioPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin(); 
        
        entityManager.merge(tatuador);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
        return true;
    }

    @Override
    public boolean delete(Long id) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("HackStudioPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.remove(entityManager.getReference(Tatuador.class, id));
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
        return true;
    }
    
    @Override
    public Object get(Long id) {
        
        Tatuador tatuador; 
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("HackStudioPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        tatuador = entityManager.find(Tatuador.class, id);
        entityManager.close();
        factory.close();
        
        List listTatuadores = new ArrayList();
        listTatuadores.add(tatuador);
        return listTatuadores ;

    }

    @Override
    public List<Object> get() {

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
