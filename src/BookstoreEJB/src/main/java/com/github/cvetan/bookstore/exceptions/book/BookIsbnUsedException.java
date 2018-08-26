package com.github.cvetan.bookstore.exceptions.book;

import com.github.cvetan.bookstore.exceptions.BookstoreException;

/**
 *
 * @author cvetan
 */
public class BookIsbnUsedException extends BookstoreException{
    
    public BookIsbnUsedException(String message) {
        super(message);
    }
    
}
