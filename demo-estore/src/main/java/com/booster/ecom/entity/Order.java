package com.booster.ecom.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    private static final long     serialVersionUID = 1L;

    private Date                  orderDate;

    private Customer              customer;

    private Collection<OrderLine> orderLines;

    public Order() {
        super();
    }

    public Order(Date orderDate, Customer customer) {
        super();
        this.orderDate = orderDate;
        this.customer = customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Collection<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Collection<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

}
