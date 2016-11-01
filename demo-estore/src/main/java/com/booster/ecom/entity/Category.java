package com.booster.ecom.entity;

import java.util.Collection;

public class Category extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String            name;
    private String            description;

    private byte[]            image;
    private String            imageName;

    private Collection<Item>  items;

}
