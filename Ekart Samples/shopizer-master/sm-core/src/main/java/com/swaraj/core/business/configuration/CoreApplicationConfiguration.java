package com.swaraj.core.business.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.swaraj.core.business"})
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.swaraj.core.business.repositories")
@EntityScan(basePackages = "com.swaraj.core.model")
@EnableTransactionManagement
@ImportResource("classpath:/spring/shopizer-core-context.xml")
public class CoreApplicationConfiguration {



}
