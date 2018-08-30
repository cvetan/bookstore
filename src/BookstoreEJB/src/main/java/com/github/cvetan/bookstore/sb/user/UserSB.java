package com.github.cvetan.bookstore.sb.user;

import com.github.cvetan.bookstore.model.User;
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
public class UserSB extends BookstoreSB implements UserSBLocal {

    @Override
    public void save(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        
        entityManager.persist(user);
    }

    @Override
    public User login(String username, String password) throws Exception {
        Query query = entityManager.createNamedQuery("User.getLogin");
        query.setParameter("username", username);
        
        List<User> userList = query.getResultList();
        
        if (userList.isEmpty()) {
            throw new Exception("Username not found!");
        }
        
        User user = userList.get(0);
        
        if (!BCrypt.checkpw(password, user.getPassword())) {
            throw new Exception("Incorrect password!");
        }
        
        return user;
    }

    
}
