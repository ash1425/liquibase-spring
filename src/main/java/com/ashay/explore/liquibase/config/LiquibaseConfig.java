package com.ashay.explore.liquibase.config;

import com.ashay.explore.liquibase.custom.CommandBasedLiquibase;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ConditionalOnNotWebApplication
public class LiquibaseConfig {
    @Bean
    public CommandBasedLiquibase springLiquibase(DataSource dataSource) {
        CommandBasedLiquibase springLiquibase = new CommandBasedLiquibase();
        springLiquibase.setChangeLog("classpath:db/changelog/db.changelog-master.xml");
        springLiquibase.setDataSource(dataSource);

        return springLiquibase;
    }
}
