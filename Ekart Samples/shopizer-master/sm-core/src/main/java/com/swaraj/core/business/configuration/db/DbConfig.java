package com.swaraj.core.business.configuration.db;

import javax.inject.Inject;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.swaraj.core.model.system.credentials.DbCredentials;

//@Configuration
//@VaultPropertySource("secret/db")
public class DbConfig {
	
    @Inject Environment env;

    @Bean
    public DbCredentials dbCredentials() {
    	DbCredentials dbCredentials = new DbCredentials();
    	dbCredentials.setUserName(env.getProperty("user"));
    	dbCredentials.setPassword(env.getProperty("password"));
        return dbCredentials;
    }

}
