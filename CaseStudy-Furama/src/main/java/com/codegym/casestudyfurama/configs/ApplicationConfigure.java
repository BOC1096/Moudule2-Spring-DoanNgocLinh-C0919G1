package com.codegym.casestudyfurama.configs;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configurable
@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories("com.codegym.casestudyfurama.repo")
@ComponentScan("com.codegym.casestudyfurama")
@EnableSpringDataWebSupport
public class ApplicationConfigure {
}
