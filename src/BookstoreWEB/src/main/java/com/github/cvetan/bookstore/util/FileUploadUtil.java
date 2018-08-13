package com.github.cvetan.bookstore.util;

import org.primefaces.model.UploadedFile;

/**
 *
 * @author cvetan
 */
public class FileUploadUtil {
    
    public static void verifyUpload(UploadedFile file) {
        if (file.getSize() == 0) {
            
        }
    }
    
    public static boolean uploaded(UploadedFile file) {
        return (file.getSize() > 0);
    }
    
    
}
