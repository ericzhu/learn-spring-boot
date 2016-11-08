package com.booster.ecom.data;

import java.math.BigDecimal;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.booster.ecom.model.entity.Category;
import com.booster.ecom.model.entity.Item;
import com.booster.ecom.service.CatalogService;

public class DemoDataSetup implements InitializingBean {

    @Autowired
    private CatalogService catalogService;

    @Override
    public void afterPropertiesSet() throws Exception {

        Item item = new Item();
        item.setName("test item");
        item.setDescription("test desc");
        item.setPrice(BigDecimal.ONE);
        catalogService.addItem(item);
        
        Category cat = new Category("Laptop", "Laptop category", null, null);
        catalogService.addCategory(cat);
    }
}
