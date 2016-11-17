package com.booster.ecom.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class Image extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String            name;

    @ManyToOne
    private User              owner;

    public Image() {

    }

    public Image(String name, User owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

}
