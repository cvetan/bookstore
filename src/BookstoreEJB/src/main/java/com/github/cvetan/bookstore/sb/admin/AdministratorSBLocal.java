/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.cvetan.bookstore.sb.admin;

import com.github.cvetan.bookstore.exceptions.administrator.AdministratorOrderFKException;
import com.github.cvetan.bookstore.model.Administrator;
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
}
