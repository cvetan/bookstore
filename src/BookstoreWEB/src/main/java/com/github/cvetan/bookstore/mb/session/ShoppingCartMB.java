package com.github.cvetan.bookstore.mb.session;

import com.github.cvetan.bookstore.cart.CartItem;
import com.github.cvetan.bookstore.model.Book;
import com.github.cvetan.bookstore.model.OrderE;
import com.github.cvetan.bookstore.model.OrderItem;
import com.github.cvetan.bookstore.sb.order.OrderSBLocal;
import com.github.cvetan.bookstore.util.Redirector;
import com.github.cvetan.bookstore.util.ResourceBundleLoader;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

/**
 *
 * @author cvetan
 */
@Named(value = "shoppingCartMB")
@SessionScoped
public class ShoppingCartMB implements Serializable {

    private List<CartItem> items;

    @EJB
    private OrderSBLocal orderSB;

    private BigDecimal total;

    private OrderE order;

    /**
     * Creates a new instance of ShoppingCartMB
     */
    public ShoppingCartMB() {
        items = new ArrayList<>();
        order = new OrderE();
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public OrderSBLocal getOrderSB() {
        return orderSB;
    }

    public void setOrderSB(OrderSBLocal orderSB) {
        this.orderSB = orderSB;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public OrderE getOrder() {
        return order;
    }

    public void setOrder(OrderE order) {
        this.order = order;
    }

    private boolean inCart(Book book) {
        for (CartItem ci : items) {
            if (ci.getBook().equals(book)) {
                return true;
            }
        }

        return false;
    }

    private CartItem getItem(Book book) {
        CartItem returnItem = null;

        for (CartItem ci : items) {
            if (ci.getBook().equals(book)) {
                returnItem = ci;

                break;
            }
        }

        if (returnItem != null) {
            return returnItem;
        }

        return new CartItem();
    }

    public void addToCart(Book book) {
        if (!inCart(book)) {
            CartItem item = new CartItem();
            item.setAmount(1);
            item.setBook(book);

            if (book.getSale()) {
                item.setPrice(book.getPromotionPrice());
            } else {
                item.setPrice(book.getMainPrice());
            }

            item.calculateTotal();

            items.add(item);
        } else {
            CartItem item = getItem(book);
            int amount = item.getAmount();
            amount++;
            item.setAmount(amount);

            item.calculateTotal();
        }

        calculateTotal();

        FacesContext context = FacesContext.getCurrentInstance();
        Flash flash = context.getExternalContext().getFlash();
        flash.setKeepMessages(true);

        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Added to cart."));
    }

    protected void calculateTotal() {
        double sum = 0;

        for (CartItem ci : items) {
            sum += ci.getTotalItem().doubleValue();
        }

        BigDecimal totalItems = new BigDecimal(sum, MathContext.DECIMAL64);

        total = totalItems;
    }
    
    public String removeFromCart(CartItem item) {
        items.remove(item);
        
        calculateTotal();
        
        String message = ResourceBundleLoader.loadFromClass("messages", "cartItemRemoved");
        
        return Redirector.redirectWithMessage(message, FacesMessage.SEVERITY_INFO, "/cart?faces-redirect=true");
    }

    public String placeOrder() {
        int index = 1;

        for (CartItem ci : items) {
            OrderItem orderItem = new OrderItem();
            orderItem.setItemNumber(index);
            orderItem.setAmount(ci.getAmount());
            orderItem.setPrice(ci.getPrice());
            orderItem.setTotalItem(ci.getTotalItem());

            order.getOrderItemList().add(orderItem);
        }

        try {
            orderSB.save(order);
            
            return Redirector.redirectWithMessage("Kupovina uspesna.", FacesMessage.SEVERITY_INFO, "/index?faces-redirec=true");
        } catch (Exception ex) {
            return Redirector.redirectWithMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR, "/cart?faces-redirect=true");
        }
    }

}
