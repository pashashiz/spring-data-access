package com.ps.tutorial.hb;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.ps.tutorial.hb.dao", "com.ps.tutorial.hb.services"})
public class DataConfig {

    @Bean public String appName() {
        return "spring-data-access/hibernate";
    }

    @Bean public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/spring_data_access");
        dataSource.setUsername("root");
        dataSource.setPassword("abcABC123");
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);
        return dataSource;
    }

    @Bean public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return properties;
    }

    @SuppressWarnings("deprecated")
    @Bean public SessionFactory sessionFactory() {
        return new LocalSessionFactoryBuilder(dataSource())
                .scanPackages("com.ps.tutorial.hb.model")
                .addProperties(hibernateProperties())
                .buildSessionFactory();
    }

    @Bean public HibernateTransactionManager txManager() {
        return new HibernateTransactionManager(sessionFactory());
    }

}
