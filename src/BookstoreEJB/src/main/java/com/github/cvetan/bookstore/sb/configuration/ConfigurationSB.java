package com.github.cvetan.bookstore.sb.configuration;

import com.github.cvetan.bookstore.model.Configuration;
import com.github.cvetan.bookstore.sb.BookstoreSB;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author cvetan
 */
@Stateless
public class ConfigurationSB extends BookstoreSB implements ConfigurationSBLocal {

    @Override
    public Map<String, String> getList() {
        clearCache();
        
        HashMap<String, String> configMap = new HashMap<>();
        
        List<Configuration> configList = entityManager.createNamedQuery("Configuration.findAll").getResultList();
        
        configList.forEach((c) -> {
            configMap.put(c.getItem(), c.getItemValue());
        });
        
        return configMap;
    }

    @Override
    public String getItem(String item) {
        clearCache();
        
        Query query = entityManager.createNamedQuery("Configuration.findByItem");
        query.setParameter("item", item);
        
        Configuration config = (Configuration) query.getSingleResult();
        
        return config.getItemValue();
    }
    
}
