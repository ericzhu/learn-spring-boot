package com.booster.ecom.service;

import com.booster.ecom.model.Cart;
import com.booster.ecom.model.entity.Customer;
import com.booster.ecom.model.entity.Order;

public interface OrderService {

    public Order placeOrder(Cart cart, Customer customer);

}
