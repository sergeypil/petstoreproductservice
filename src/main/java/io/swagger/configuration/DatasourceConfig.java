package io.swagger.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

    @Value("${PETSTORE_PRODUCT_SERVICE_DB_URL_REF}")
    private String dbUrlSecretRef;

    @Value("${PETSTORE_PRODUCT_SERVICE_DB_USERNAME_REF}")
    private String dbUsernameSecretRef;

    @Value("${PETSTORE_PRODUCT_SERVICE_DB_PASSWORD_REF}")
    private String dbPasswordSecretRef;
    
    private final KeyVaultService keyVaultService;

    public DatasourceConfig(KeyVaultService keyVaultService) {
        this.keyVaultService = keyVaultService;
    }

    @Bean
    public DataSource dataSource() {
        String dbUrl = keyVaultService.getSecretValue(dbUrlSecretRef);
        String username = keyVaultService.getSecretValue(dbUsernameSecretRef);
        String password = keyVaultService.getSecretValue(dbPasswordSecretRef);

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("org.postgresql.Driver");
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setJdbcUrl(dbUrl);
        return new HikariDataSource(hikariConfig);
    }
}