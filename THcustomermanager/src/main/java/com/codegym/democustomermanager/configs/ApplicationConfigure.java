package com.codegym.democustomermanager.configs;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

public class ApplicationConfigure {
    @Configurable
    @EnableJpaRepositories("com.codegym.democustomermanager.repo")
    public static class ApplicationConfiguration {

    }
}
