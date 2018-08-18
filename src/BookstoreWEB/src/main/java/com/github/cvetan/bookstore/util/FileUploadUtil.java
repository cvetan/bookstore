package com.github.cvetan.bookstore.util;

import com.github.slugify.Slugify;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    
    public static String generateFilename(String base) {
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        Slugify slugify = new Slugify();
        
        return slugify.slugify(base) + "-" + format.format(date);
    }
}
