package com.marcelo.helpdesk.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.marcelo.helpdesk.service.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String value;
	
	@Bean
	public boolean instanciaDBServcice() {
		
		if (value.equals("create")) {
			this.dbService.instanciaBD();
		}		
		return false;		
	}
	
}