package com.github.cvetan.bookstore.sb.admin;

import com.github.cvetan.bookstore.exceptions.administrator.AdministratorEmailUsedException;
import com.github.cvetan.bookstore.exceptions.administrator.AdministratorOrderFKException;
import com.github.cvetan.bookstore.exceptions.administrator.AdministratorUsernameUsedException;
import com.github.cvetan.bookstore.exceptions.session.admin.IncorrectPasswordException;
import com.github.cvetan.bookstore.exceptions.session.admin.NoAccountException;
import com.github.cvetan.bookstore.model.Administrator;
import com.github.cvetan.bookstore.sb.BookstoreSB;
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
    public void save(Administrator administrator) throws AdministratorEmailUsedException, AdministratorUsernameUsedException{
        List<String> usernameList = entityManager.createNamedQuery("Administrator.getUsernameList").getResultList();
        List<String> emailList = entityManager.createNamedQuery("Administrator.getEmailList").getResultList();
        
        if (usernameList.contains(administrator.getUsername())) {
            throw new AdministratorUsernameUsedException("administratorUsernameUsedError");
        }
        
        if (emailList.contains(administrator.getEmail())) {
            throw new AdministratorEmailUsedException("administratorEmailUsedError");
        }
        
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
    public void update(Administrator administrator) throws AdministratorEmailUsedException, AdministratorUsernameUsedException {
        Query query = entityManager.createNamedQuery("Administrator.getUsernameListUpdate");
        query.setParameter("id", administrator.getId());
        List<String> usernameList = query.getResultList();
        
        query = entityManager.createNamedQuery("Administrator.getEmailListUpdate");
        query.setParameter("id", administrator.getId());
        List<String> emailList = query.getResultList();
        
        if (usernameList.contains(administrator.getUsername())) {
            throw new AdministratorUsernameUsedException("administratorUsernameUsedError");
        }
        
        if (emailList.contains(administrator.getEmail())) {
            throw new AdministratorEmailUsedException("administratorEmailUsedError");
        }
        
        if (administrator.getPassword() == null) {
            Administrator oldAdministrator = entityManager.find(Administrator.class, administrator.getId());
            
            administrator.setPassword(oldAdministrator.getPassword());
        } else {
            administrator.setPassword(BCrypt.hashpw(administrator.getPassword(), BCrypt.gensalt()));
        }

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
