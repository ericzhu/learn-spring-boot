package com.booster.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockRestService {
	
	@Value("${database.type}")
	private String databaseType;
	
	@RequestMapping(value = "/dbType")
	public String databaseType() {
		return databaseType;
	}
	
}
