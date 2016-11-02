package com.booster.ecom.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ECOM_ITEM")
public class Item extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @NotEmpty
    @Size(min=4, max=50)
    private String            name;

    private String            description;

    private BigDecimal        price;

    private boolean           selected;

    private String            image;

    private int               quantity;

    @ManyToOne
    @JoinColumn(name = "CAT_ID")
    private Category          category;

    public Item() {
        super();
    }

    public Item(String name, String description, BigDecimal price, boolean selected, String image, int quantity) {
        super();
        this.name = name;
        this.description = description;
        this.price = price;
        this.selected = selected;
        this.image = image;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
