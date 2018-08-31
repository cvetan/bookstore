package com.github.cvetan.bookstore.mb.address;

import com.github.cvetan.bookstore.mb.session.UserSessionMB;
import com.github.cvetan.bookstore.model.Address;
import com.github.cvetan.bookstore.model.City;
import com.github.cvetan.bookstore.sb.address.AddressSBLocal;
import com.github.cvetan.bookstore.sb.city.CitySBLocal;
import com.github.cvetan.bookstore.util.Redirector;
import com.github.cvetan.bookstore.util.ResourceBundleLoader;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author cvetan
 */
@Named(value = "newAddressMB")
@ViewScoped
public class NewAddressMB implements Serializable {
    
    @EJB
    private CitySBLocal citySB;
    
    @EJB
    private AddressSBLocal addressSB;
    
    private Address address;
    
    private List<City> cities;
    
    @Inject
    private UserSessionMB userSessionMB;

    /**
     * Creates a new instance of NewAddressMB
     */
    public NewAddressMB() {
    }

    public CitySBLocal getCitySB() {
        return citySB;
    }

    public void setCitySB(CitySBLocal citySB) {
        this.citySB = citySB;
    }

    public AddressSBLocal getAddressSB() {
        return addressSB;
    }

    public void setAddressSB(AddressSBLocal addressSB) {
        this.addressSB = addressSB;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
    
    @PostConstruct
    public void initData() {
        cities = citySB.getList();
        address = new Address();
    }

    public String save() {
        try {
            address.setUser(userSessionMB.getUser());
            
            addressSB.save(address);
            
            userSessionMB.getUser().getAddressList().add(address);
            
            String message = ResourceBundleLoader.loadFromClass("messages", "addressSaved");
            
            return Redirector.redirectWithMessage(message, FacesMessage.SEVERITY_INFO, "/index?faces-redirect=true");
        } catch (Exception ex) {
            return Redirector.redirectWithMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR, "/new-address?faces-redirect=true");
        }
    }
    
}
