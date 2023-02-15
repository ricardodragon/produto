package com.dibros.produto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages={"com.dibros.core.model", "com.dibros.produto.model"})
@EnableJpaRepositories({"com.dibros.produto.repository"})
@ComponentScan("com.dibros")
public class ProdutoApplication {


    public static void main(String[] args) {
        SpringApplication.run(ProdutoApplication.class, args);
    }

}

