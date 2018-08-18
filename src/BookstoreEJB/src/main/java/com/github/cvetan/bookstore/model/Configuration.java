package com.github.cvetan.bookstore.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cvetan
 */
@Entity
@Table(name = "configuration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configuration.findAll", query = "SELECT c FROM Configuration c")
    , @NamedQuery(name = "Configuration.findByItem", query = "SELECT c FROM Configuration c WHERE c.item = :item")})
public class Configuration implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "item")
    private String item;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "item_value")
    private String itemValue;

    public Configuration() {
    }

    public Configuration(String item) {
        this.item = item;
    }

    public Configuration(String item, String itemValue) {
        this.item = item;
        this.itemValue = itemValue;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (item != null ? item.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Configuration)) {
            return false;
        }
        
        Configuration other = (Configuration) object;
        
        return !((this.item == null && other.item != null) 
                || (this.item != null && !this.item.equals(other.item)));
    }

    @Override
    public String toString() {
        return item + ":" + itemValue;
    }
    
}
