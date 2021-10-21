package com.swaraj.test.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.swaraj.core.business"})
@ImportResource("spring/test-shopizer-context.xml")
@EnableJpaRepositories(basePackages = "com.swaraj.core.business.repositories")
@EntityScan(basePackages = "com.swaraj.core.model")
public class ConfigurationTest {
	
}
