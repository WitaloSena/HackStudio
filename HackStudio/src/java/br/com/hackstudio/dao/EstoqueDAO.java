/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hackstudio.dao;

import br.com.hackstudio.model.Estoque;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author witalo
 */
public class EstoqueDAO implements Dao{

    @Override
    public boolean save(Object object) {
       Estoque estoque = (Estoque) object;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("HackStudioPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        
        entityManager.persist(estoque);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
        return true;
    }

    @Override
    public boolean update(Object object) {
        Estoque estoque = (Estoque) object;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("HackStudioPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin(); 
        
        entityManager.merge(estoque);
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

        entityManager.remove(entityManager.getReference(Estoque.class, id));
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
        return true;    }

    @Override
    public Object get(Long id) {
        Estoque estoque; 
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("HackStudioPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        estoque = entityManager.find(Estoque.class, id);
        entityManager.close();
        factory.close();
        
        List listEstoque = new ArrayList();
        listEstoque.add(estoque);
        return listEstoque ;
    }

    @Override
    public List<Object> get() {
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("HackStudioPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        String jpql = "select e from Estoque e";
        Query query = entityManager.createQuery(jpql);
        List<Object> listEstoque = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return listEstoque;
    }
    
}
