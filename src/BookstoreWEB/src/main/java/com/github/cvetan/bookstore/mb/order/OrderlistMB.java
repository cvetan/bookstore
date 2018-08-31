package com.github.cvetan.bookstore.mb.order;

import com.github.cvetan.bookstore.model.OrderE;
import com.github.cvetan.bookstore.sb.configuration.ConfigurationSBLocal;
import com.github.cvetan.bookstore.sb.order.OrderSBLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;


/**
 *
 * @author cvetan
 */
@Named(value = "orderlistMB")
@ViewScoped
public class OrderlistMB implements Serializable {
    
    @EJB
    private OrderSBLocal orderSB;
    
    @EJB
    private ConfigurationSBLocal configurationSB;
    
    private List<OrderE> list;
    
    private int paginationLimit;
    
    private boolean selected;
    
    private OrderE selectedOrder;

    /**
     * Creates a new instance of OrderlistMB
     */
    public OrderlistMB() {
    }

    public OrderSBLocal getOrderSB() {
        return orderSB;
    }

    public void setOrderSB(OrderSBLocal orderSB) {
        this.orderSB = orderSB;
    }

    public ConfigurationSBLocal getConfigurationSB() {
        return configurationSB;
    }

    public void setConfigurationSB(ConfigurationSBLocal configurationSB) {
        this.configurationSB = configurationSB;
    }

    public List<OrderE> getList() {
        return list;
    }

    public void setList(List<OrderE> list) {
        this.list = list;
    }

    public int getPaginationLimit() {
        return paginationLimit;
    }

    public void setPaginationLimit(int paginationLimit) {
        this.paginationLimit = paginationLimit;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public OrderE getSelectedOrder() {
        return selectedOrder;
    }

    public void setSelectedOrder(OrderE selectedOrder) {
        this.selectedOrder = selectedOrder;
    }
    
    @PostConstruct
    public void initData() {
        list = orderSB.getUnprocessedList();
        paginationLimit = Integer.parseInt(configurationSB.getItem("backendPaginationLimit"));
    }
    
    public String showDetails() {
        
        return "/admin/order?faces-redirect=true";
    }
    
    public void onRowSelect() {
        selected = true;
    }
    
    public void onRowUnselect() {
        selected = false;
    }
    
}
