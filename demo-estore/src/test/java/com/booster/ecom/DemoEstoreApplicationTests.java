package com.booster.ecom;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.booster.ecom.model.entity.Item;
import com.booster.ecom.service.CatalogService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoEstoreApplicationTests {

    @Autowired
    private CatalogService catalogService;
    
	@Test
	public void contextLoads() {
	    Item item = new Item();
	    item.setName("test item");
	    item.setDescription("test desc");
	    item.setPrice(BigDecimal.ONE);
	    catalogService.addItem(item);
	}

}
