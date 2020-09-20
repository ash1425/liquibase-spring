package com.ashay.explore.liquibase;

import com.ashay.explore.liquibase.custom.CommandBasedLiquibase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnNotWebApplication
public class LiquibaseRunner implements CommandLineRunner {

    private final CommandBasedLiquibase liquibase;

    public LiquibaseRunner(CommandBasedLiquibase liquibase) {
        this.liquibase = liquibase;
    }

    public void run(String... args) throws Exception {
        String command = args[0];
        liquibase.run(command);
    }
}
