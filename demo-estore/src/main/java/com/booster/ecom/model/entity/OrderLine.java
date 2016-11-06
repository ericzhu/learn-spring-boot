package com.booster.ecom.model.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_line")
public class OrderLine extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne(optional = false)
    @JoinColumn(name = "item_id")
    private Item              item;

    private Integer           quantity         = 0;

    private BigDecimal        price;

    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id")
    private Order             order;

    public OrderLine(Integer quantity, BigDecimal price) {
        super();
        this.quantity = quantity;
        this.price = price;
    }

    public OrderLine() {
        super();
    }

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

    public void addQuantity(Integer quantity) {
        if (quantity > 0) {
            this.quantity += quantity;
        }
    }

}
