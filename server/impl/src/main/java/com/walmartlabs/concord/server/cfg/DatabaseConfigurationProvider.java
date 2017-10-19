package com.walmartlabs.concord.server.cfg;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class DatabaseConfigurationProvider extends AbstractDatabaseConfigurationProvider {

    public static final String DB_USERNAME_KEY = "DB_USERNAME";
    public static final String DEFAULT_DB_USERNAME = "postgres";

    public static final String DB_PASSWORD_KEY = "DB_PASSWORD";
    public static final String DEFAULT_DB_PASSWORD = "q1";

    public DatabaseConfigurationProvider() {
        super(DB_USERNAME_KEY, DEFAULT_DB_USERNAME, DB_PASSWORD_KEY, DEFAULT_DB_PASSWORD);
    }
}
