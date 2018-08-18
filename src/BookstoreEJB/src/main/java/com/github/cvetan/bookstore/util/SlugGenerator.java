package com.github.cvetan.bookstore.util;

import com.github.slugify.Slugify;
import java.util.List;

/**
 *
 * @author cvetan
 */
public class SlugGenerator {
    
    public static String generateSlug(String base, List<String> existing) {
        String slug = base;
        
        int index = 1;
        
        while (existing.contains(slug)) {
            slug = base + "-" + index;
            
            index++;
        }
        
        return slug;
    }
    
    public static String generateSlugRaw(String raw, List<String> existing) {
        Slugify slugify = new Slugify();
        String base = slugify.slugify(raw);
        
        String slug = base;
        
        int index = 1;
        
        while (existing.contains(slug)) {
            slug = base + "-" + index;
            
            index++;
        }
        
        return slug;
    }
}
