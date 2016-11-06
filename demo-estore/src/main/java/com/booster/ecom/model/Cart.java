package com.booster.ecom.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.booster.ecom.model.entity.Item;
import com.booster.ecom.model.entity.OrderLine;

public class Cart implements Serializable {

    private static final long    serialVersionUID = 1L;

    private Map<Long, OrderLine> items            = new HashMap<>();

    public void addItem(Item item, Integer quantity) {

        OrderLine orderLine = items.get(item.getId());

        if (orderLine == null) {
            orderLine = new OrderLine();
            orderLine.setItem(item);
            orderLine.setPrice(item.getPrice());
            items.put(item.getId(), orderLine);
        }

        orderLine.addQuantity(quantity);
    }

    public Collection<OrderLine> getItems() {
        return items.values();
    }

    public BigDecimal getCartTotal() {
        List<BigDecimal> lineTotals = new ArrayList<>();
        getItems().forEach(ol -> lineTotals.add(calculateLineTotal(ol)));
        return lineTotals.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateLineTotal(OrderLine orderLine) {
        return orderLine.getPrice().multiply(new BigDecimal(orderLine.getQuantity()));
    }

    public Integer getSize() {
        return items.size();
    }

    public void removeItem(Long itemId) {
        items.remove(itemId);
    }
}
