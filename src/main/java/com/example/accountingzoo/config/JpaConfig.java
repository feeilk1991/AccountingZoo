package com.example.accountingzoo.config;

import com.example.accountingzoo.service.AnimalService;
import com.example.accountingzoo.service.AnimalServiceImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;

@Configuration
@ComponentScan({"com.example"})
@EntityScan(basePackages = "com.example")
@EnableJpaRepositories(basePackages = "com.example.accountingzoo.repository")
public class JpaConfig {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver"); // Указываем класс драйвера базы данных
        dataSource.setUrl("jdbc:postgresql://localhost:5432/zoo"); // Указываем URL базы данных
        dataSource.setUsername("postgres"); // Указываем имя пользователя базы данных
        dataSource.setPassword("postgres"); // Указываем пароль пользователя базы данных
        return dataSource;
    }

    @Bean("animalService")
    public AnimalService animalService(){
        return new AnimalServiceImpl();
    }
}
