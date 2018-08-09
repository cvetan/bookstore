package com.github.cvetan.bookstore.util;

import com.cloudinary.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FilenameUtils;

public class CloudinaryFacade {
    
    private final static Map<Object, Object> CONFIG = new HashMap<>();

    static {
        CONFIG.put("cloud_name", "cvetan");
        CONFIG.put("api_key", "566294915996573");
        CONFIG.put("api_secret", "XVGmRN0fr-I6MspX71JP0PUKZrw");
    }

    public CloudinaryFacade() {
    }
    
    public static String uploadAuthorImage(File file) throws IOException {
        Cloudinary cloudinary = new Cloudinary(CONFIG);
        
        Map<Object, Object> parameters = new HashMap<>();
        
        String filename = FilenameUtils.getBaseName(file.getName());
        
        parameters.put("public_id", "Bookstore/Authors/Images/" + filename);

        Map result = cloudinary.uploader().upload(file, parameters);

        return (String) result.get("url");
    }
    
    public static String resizeAuthorImage(String image) {
        
        return null;
    }
}
