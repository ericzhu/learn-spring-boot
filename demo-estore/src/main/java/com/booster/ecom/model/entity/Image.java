package com.booster.ecom.model.entity;

import javax.persistence.Entity;

@Entity
public class Image extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String            name;

    public Image() {

    }

    public Image(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
