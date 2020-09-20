package com.ashay.explore.liquibase.custom;

import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;

import java.sql.SQLException;

public class CommandBasedLiquibase extends SpringLiquibase {

    @Override
    public void afterPropertiesSet() throws LiquibaseException {
        // Don't run automatically
    }

    public void run(String command) throws LiquibaseException {
        try (var connection = getDataSource().getConnection()) {
            if (command.equals("updateSQL")) {
                createLiquibase(connection).update(getContexts(), System.console().writer());
            } else if (command.equals("update")) {
                createLiquibase(connection).update(getContexts());
            } else if (command.equals("dropAll")) {
                createLiquibase(connection).dropAll();
            }
        } catch (LiquibaseException | SQLException e) {
            throw new DatabaseException(e);
        }
    }
}
