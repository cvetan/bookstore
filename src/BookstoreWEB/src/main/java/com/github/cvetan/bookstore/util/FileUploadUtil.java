package com.github.cvetan.bookstore.util;

import com.github.slugify.Slugify;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FilenameUtils;
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
    
    public static File generateTempFile(InputStream content, String baseFilename) throws IOException{
        String folder = Constants.TMP_FILES_PATH;
        String filename = FilenameUtils.getBaseName(baseFilename);
        String extension = FilenameUtils.getExtension(baseFilename);
        String filepath = folder + "/" + filename + "." + extension;
        
        File file = File.createTempFile(filepath, "");
        
        Files.copy(content, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        
        return file;
    }
}
