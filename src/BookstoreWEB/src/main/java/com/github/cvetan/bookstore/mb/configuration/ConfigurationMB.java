package com.github.cvetan.bookstore.mb.configuration;

import com.github.cvetan.bookstore.sb.configuration.ConfigurationSBLocal;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author cvetan
 */
@Named(value = "configurationMB")
@RequestScoped
public class ConfigurationMB {
    
    @EJB
    private ConfigurationSBLocal configurationSB;
    
    private Map<String, String> settings;

    /**
     * Creates a new instance of ConfigurationMB
     */
    public ConfigurationMB() {
    }

    public ConfigurationSBLocal getConfigurationSB() {
        return configurationSB;
    }

    public void setConfigurationSB(ConfigurationSBLocal configurationSB) {
        this.configurationSB = configurationSB;
    }

    public Map<String, String> getSettings() {
        return settings;
    }

    public void setSettings(Map<String, String> settings) {
        this.settings = settings;
    }
    
    @PostConstruct
    public void initPage() {
        settings = configurationSB.getList();
    }
    
    public String update() {
        
        return null;
    }
}
