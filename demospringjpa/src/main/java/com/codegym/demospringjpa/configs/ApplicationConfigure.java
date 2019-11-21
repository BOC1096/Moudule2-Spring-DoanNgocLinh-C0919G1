package com.codegym.demospringjpa.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

public class ApplicationConfigure {
    @Configuration
    @EnableJpaRepositories("com.codegym.demospringjpa.repository")
    public static class ApplicationConfiguration {

    }
}
