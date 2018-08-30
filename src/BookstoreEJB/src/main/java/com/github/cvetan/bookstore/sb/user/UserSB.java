package com.github.cvetan.bookstore.sb.user;

import com.github.cvetan.bookstore.model.User;
import com.github.cvetan.bookstore.sb.BookstoreSB;
import javax.ejb.Stateless;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author cvetan
 */
@Stateless
public class UserSB extends BookstoreSB implements UserSBLocal {

    @Override
    public void save(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        
        entityManager.persist(user);
    }

    @Override
    public User login(String username, String password) {
        
        return new User();
    }

    
}
