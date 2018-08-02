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
