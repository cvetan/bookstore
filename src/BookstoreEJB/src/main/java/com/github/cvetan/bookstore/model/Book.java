/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.cvetan.bookstore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cvetan
 */
@Entity
@Table(name = "books")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b")
    , @NamedQuery(name = "Book.findById", query = "SELECT b FROM Book b WHERE b.id = :id")
    , @NamedQuery(name = "Book.findByActive", query = "SELECT b FROM Book b WHERE b.active = :active")
    , @NamedQuery(name = "Book.findByIsbn", query = "SELECT b FROM Book b WHERE b.isbn = :isbn")
    , @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title")
    , @NamedQuery(name = "Book.findBySlug", query = "SELECT b FROM Book b WHERE b.slug = :slug")
    , @NamedQuery(name = "Book.findByFormat", query = "SELECT b FROM Book b WHERE b.format = :format")
    , @NamedQuery(name = "Book.findByPageNumber", query = "SELECT b FROM Book b WHERE b.pageNumber = :pageNumber")
    , @NamedQuery(name = "Book.findByAlphabet", query = "SELECT b FROM Book b WHERE b.alphabet = :alphabet")
    , @NamedQuery(name = "Book.findByCover", query = "SELECT b FROM Book b WHERE b.cover = :cover")
    , @NamedQuery(name = "Book.findByPublishDate", query = "SELECT b FROM Book b WHERE b.publishDate = :publishDate")
    , @NamedQuery(name = "Book.findByImage", query = "SELECT b FROM Book b WHERE b.image = :image")
    , @NamedQuery(name = "Book.findByThumbnail", query = "SELECT b FROM Book b WHERE b.thumbnail = :thumbnail")
    , @NamedQuery(name = "Book.findByTitleTag", query = "SELECT b FROM Book b WHERE b.titleTag = :titleTag")
    , @NamedQuery(name = "Book.findByDescriptionTag", query = "SELECT b FROM Book b WHERE b.descriptionTag = :descriptionTag")
    , @NamedQuery(name = "Book.findByCreatedAt", query = "SELECT b FROM Book b WHERE b.createdAt = :createdAt")
    , @NamedQuery(name = "Book.findByUpdatedAt", query = "SELECT b FROM Book b WHERE b.updatedAt = :updatedAt")})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "isbn")
    private String isbn;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "slug")
    private String slug;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "format")
    private String format;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "page_number")
    private int pageNumber;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "alphabet")
    private String alphabet;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cover")
    private String cover;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "publish_date")
    @Temporal(TemporalType.DATE)
    private Date publishDate;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "image")
    private String image;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "thumbnail")
    private String thumbnail;
    
    @Size(max = 255)
    @Column(name = "title_tag")
    private String titleTag;
    
    @Size(max = 255)
    @Column(name = "description_tag")
    private String descriptionTag;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    @ManyToMany(mappedBy = "wishlist")
    private List<User> userList;
    
    @JoinTable(name = "books_categories", joinColumns = {
        @JoinColumn(name = "book_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "category_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Category> categoryList;
    
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Author author;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private List<OrderItem> orderItemList;

    public Book() {
        userList = new ArrayList<>();
        categoryList = new ArrayList<>();
        orderItemList = new ArrayList<>();
    }

    public Book(Integer id) {
        this.id = id;
    }

    public Book(Integer id, boolean active, String isbn, String title, String slug, String description, String format, int pageNumber, String alphabet, String cover, Date publishDate, String image, String thumbnail, Date createdAt) {
        this.id = id;
        this.active = active;
        this.isbn = isbn;
        this.title = title;
        this.slug = slug;
        this.description = description;
        this.format = format;
        this.pageNumber = pageNumber;
        this.alphabet = alphabet;
        this.cover = cover;
        this.publishDate = publishDate;
        this.image = image;
        this.thumbnail = thumbnail;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitleTag() {
        return titleTag;
    }

    public void setTitleTag(String titleTag) {
        this.titleTag = titleTag;
    }

    public String getDescriptionTag() {
        return descriptionTag;
    }

    public void setDescriptionTag(String descriptionTag) {
        this.descriptionTag = descriptionTag;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @XmlTransient
    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @XmlTransient
    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if ( ! (object instanceof Book)) {
            return false;
        }
        
        Book other = (Book) object;
        
        return ! ((this.id == null && other.id != null) || 
                  (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return title + " - " + author.getName();
    }
    
    @PrePersist
    public void prePersist() {
        createdAt = new Date();
    }
    
    @PreUpdate
    public void preUpdate() {
        updatedAt = new Date();
    }
    
}
