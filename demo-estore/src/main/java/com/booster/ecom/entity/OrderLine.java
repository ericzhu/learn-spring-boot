package com.booster.ecom.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class OrderLine extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Item              item;

    private Integer           quantity;

    private BigDecimal        price;

    private Order             order;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
