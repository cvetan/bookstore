package com.github.cvetan.bookstore.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author cvetan
 */
public class FilesFacade {
    
    public static File createTempFile(InputStream content, String uploadFileName) throws IOException {
        String folder = Constants.TMP_FILES_PATH;
        String filename = FilenameUtils.getBaseName(uploadFileName);
        String extension = FilenameUtils.getExtension(uploadFileName);
        String filepath = folder + "/" + filename + "." + extension;
        
        File file = File.createTempFile(filepath, "");
        
        Files.copy(content, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        
        return file;
    }
}
