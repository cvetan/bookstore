package com.github.cvetan.bookstore.util;

import java.util.ResourceBundle;

/**
 *
 * @author cvetan
 */
public class ResourceBundleLoader {
    
    private static final String rootPackage = "com.github.cvetan.bookstore.localization";
    
    public static String loadFromClass(String className, String key) {
        ResourceBundle bundle = ResourceBundle.getBundle(rootPackage + "." + className);
        
        return bundle.getString(key);
    }
    
}
