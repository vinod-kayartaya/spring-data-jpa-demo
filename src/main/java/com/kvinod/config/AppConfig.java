package com.kvinod.config;

import jakarta.persistence.EntityManagerFactory;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = {"com.kvinod.dao"})
@ComponentScan(basePackages = {"com.kvinod.service"})
@PropertySource({"classpath:jdbc-info.properties"})
public class AppConfig {

    @Bean
    public BasicDataSource h2ds(
            @Value("${jdbc.connection.url}") String url,
            @Value("${jdbc.connection.username}") String username,
            @Value("${jdbc.connection.password}") String password,
            @Value("${jdbc.connection.driverClassName}") String driverClassName
    ) {
        BasicDataSource bds = new BasicDataSource();
        bds.setUrl(url);
        bds.setUsername(username);
        bds.setPassword(password);
        bds.setDriverClassName(driverClassName);

        bds.setInitialSize(5);
        bds.setMaxTotal(50);
        bds.setMaxWaitMillis(100);

        return bds;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource){
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setPackagesToScan("com.kvinod.entity");
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
