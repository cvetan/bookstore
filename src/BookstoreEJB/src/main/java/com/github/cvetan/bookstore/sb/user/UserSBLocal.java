package com.github.cvetan.bookstore.sb.user;

import com.github.cvetan.bookstore.model.User;
import javax.ejb.Local;

/**
 *
 * @author cvetan
 */
@Local
public interface UserSBLocal {
    
    public void save(User user);
    
    public User login(String username, String password);
}
