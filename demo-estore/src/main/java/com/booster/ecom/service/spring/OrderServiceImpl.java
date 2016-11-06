package com.booster.ecom.service.spring;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.booster.ecom.model.Cart;
import com.booster.ecom.model.entity.Customer;
import com.booster.ecom.model.entity.Order;
import com.booster.ecom.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Override
    public Order placeOrder(Cart cart, Customer customer) {
        return null;
    }

}
