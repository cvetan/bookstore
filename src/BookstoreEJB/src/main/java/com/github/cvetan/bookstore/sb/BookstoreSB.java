/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.cvetan.bookstore.sb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cvetan
 */
public class BookstoreSB {
    
    @PersistenceContext (unitName = "BookstorePU")
    protected EntityManager entityManager;

    public BookstoreSB() {
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public void clearCache() {
        entityManager.getEntityManagerFactory().getCache().evictAll();
    }
    
}
