package com.github.cvetan.bookstore.sb.configuration;

import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author cvetan
 */
@Local
public interface ConfigurationSBLocal {
    
    public Map<String, String> getList();
    
    public String getItem(String item);
}
