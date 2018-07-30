package com.github.cvetan.bookstore.exceptions;

import com.github.cvetan.bookstore.util.ResourceBundleLoader;

/**
 *
 * @author cvetan
 */
public class BookstoreException extends Exception {

    public BookstoreException(String message) {
        super(ResourceBundleLoader.loadFromClass("exceptionMessages", message));
    }
    
}
