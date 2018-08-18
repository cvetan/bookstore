package com.github.cvetan.bookstore.util;

import com.cloudinary.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FilenameUtils;

public class CloudinaryFacade {
    
    private Cloudinary cloudinary;
    
    private static CloudinaryFacade instance;

    public CloudinaryFacade() {
    }
    
    public static CloudinaryFacade getInstance() {
        if (instance != null) {
            return instance;
        }
        
        instance = new CloudinaryFacade();
        
        Map<Object, Object> config = new HashMap<>();
        config.put("cloud_name", "cvetan");
        config.put("api_key", "566294915996573");
        config.put("api_secret", "XVGmRN0fr-I6MspX71JP0PUKZrw");
        
        instance.cloudinary = new Cloudinary(config);
        
        return instance;
    }
    
    public Map uploadAuthorImage(File file) throws IOException {
        Map<Object, Object> parameters = new HashMap<>();
        
        String filename = FilenameUtils.getBaseName(file.getName());
        
        parameters.put("public_id", "Bookstore/Authors/Images/" + filename);

        Map result = cloudinary.uploader().upload(file, parameters);

        return result;
    }
    
    public static String resizeAuthorImage(String image) {
        
        return null;
    }
}
