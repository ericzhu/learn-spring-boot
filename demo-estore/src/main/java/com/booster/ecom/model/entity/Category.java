package com.booster.ecom.model.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "CATEGORY")
public class Category extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @NotEmpty
    @Size(min = 4, max = 50)
    private String            name;

    @Size(min = 4)
    private String            description;

    @Lob
    private byte[]            image;

    private String            imageName;

    @OneToMany(mappedBy = "category")
    private Collection<Item>  items;

    public Category(String name, String description, byte[] image, String imageName) {
        super();
        this.name = name;
        this.description = description;
        this.image = image;
        this.imageName = imageName;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }
}
