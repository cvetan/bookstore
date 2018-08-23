package com.github.cvetan.bookstore.sb.admin;

import com.github.cvetan.bookstore.exceptions.administrator.AdministratorOrderFKException;
import com.github.cvetan.bookstore.model.Administrator;
import com.github.cvetan.bookstore.sb.BookstoreSB;
import com.github.cvetan.bookstore.exceptions.session.admin.IncorrectPasswordException;
import com.github.cvetan.bookstore.exceptions.session.admin.NoAccountException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author cvetan
 */
@Stateless
public class AdministratorSB extends BookstoreSB implements AdministratorSBLocal {

    @Override
    public List<Administrator> getList() {
        return entityManager.createNamedQuery("Administrator.findAll").getResultList();
    }

    @Override
    public void save(Administrator administrator) {
        administrator.setPassword(BCrypt.hashpw(administrator.getPassword(), BCrypt.gensalt()));

        entityManager.persist(administrator);

        clearCache();
    }

    @Override
    public Administrator getById(int id) {
        Query query = entityManager.createNamedQuery("Administrator.findById");
        query.setParameter("id", id);

        Administrator administrator = (Administrator) query.getSingleResult();

        return administrator;

    }

    @Override
    public void update(Administrator administrator) {
        administrator.setPassword(BCrypt.hashpw(administrator.getPassword(), BCrypt.gensalt()));

        entityManager.merge(administrator);

        clearCache();
    }

    @Override
    public void delete(int id) throws AdministratorOrderFKException {
        Administrator administrator = (Administrator) entityManager.find(Administrator.class, id);

        if (!administrator.getOrderList().isEmpty()) {
            throw new AdministratorOrderFKException("administratorAssignedError");
        }

        entityManager.remove(administrator);

        clearCache();
    }

    @Override
    public Administrator login(String username, String password) throws NoAccountException, IncorrectPasswordException{
        Query query = entityManager.createNamedQuery("Administrator.getLogin");
        query.setParameter("username", username);
        
        List<Administrator> list = query.getResultList();
        
        if (list.isEmpty()) {
            throw new NoAccountException("noAdminFound");
        }
        
        Administrator administrator = list.get(0);
        
        if (!BCrypt.checkpw(password, administrator.getPassword())) {
            throw new IncorrectPasswordException("incorrectPassword");
        }
        
        return administrator;
    }
}
