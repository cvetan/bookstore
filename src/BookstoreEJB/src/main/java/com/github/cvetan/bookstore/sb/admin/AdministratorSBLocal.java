package com.github.cvetan.bookstore.sb.admin;

import com.github.cvetan.bookstore.exceptions.administrator.AdministratorOrderFKException;
import com.github.cvetan.bookstore.model.Administrator;
import com.github.cvetan.bookstore.exceptions.session.admin.IncorrectPasswordException;
import com.github.cvetan.bookstore.exceptions.session.admin.NoAccountException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cvetan
 */
@Local
public interface AdministratorSBLocal {
    
    public List<Administrator> getList();
    
    public void save(Administrator administrator);
    
    public Administrator getById(int id);
    
    public void update(Administrator administrator);
    
    public void delete(int id) throws AdministratorOrderFKException;
    
    public Administrator login(String username, String password) throws NoAccountException, IncorrectPasswordException;
}
