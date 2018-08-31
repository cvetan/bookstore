package com.github.cvetan.bookstore.cart;

import com.github.cvetan.bookstore.model.Book;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

/**
 *
 * @author cvetan
 */
public class CartItem implements Serializable {
    
    private Book book;
    
    private BigDecimal price;
    
    private int amount;
    
    private BigDecimal totalItem;

    public CartItem() {
    }

    public CartItem(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(BigDecimal totalItem) {
        this.totalItem = totalItem;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final CartItem other = (CartItem) obj;
        
        return Objects.equals(this.book, other.book);
    }
    
    public void calculateTotal() {
        double itemPrice = amount * price.doubleValue();
        
        totalItem = new BigDecimal(itemPrice, MathContext.DECIMAL64);
    }
}
