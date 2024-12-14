package com.desarrollo.tpSpring.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.desarrollo.tpSpring.DAOs")
@EntityScan(basePackages = "com.desarrollo.tpSpring.entities")
public class JpaConfig {
}