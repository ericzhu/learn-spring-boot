package com.booster;

import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.booster.entity.Company;
import com.booster.repository.CompanyRepository;

@SpringBootApplication
public class StockCompanyServiceApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StockCompanyServiceApplication.class, args);
		CompanyRepository companyRepository = context.getBean(CompanyRepository.class);
		Stream.of("GE", "IBM", "GOOGLE", "TESLA", "MSFT", "PYPL", "INTC", "AAPL", "CSCO", "SIRI", "MU", "ALKS", "QQQ",
				"QCOM", "HBAN", "XIV", "EBAY", "FB", "CMCSA", "GILD", "AMAT", "AAL", "MDLZ", "NXPI")
				.forEach(c -> companyRepository.save(new Company(c)));

		companyRepository.findAll().forEach(c -> System.out.println(c.getName()));
	}
}

// @Configuration
// class RepositoryConfig extends RepositoryRestMvcConfiguration {
// @Override
// protected void
// configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
// config.exposeIdsFor(Company.class);
// }
// }
