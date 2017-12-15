package tmarshal.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConfig {
    @Bean(name = "datasource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:~/myDB;MV_STORE=false");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        try {
            // schema init
            Resource initSchema = new ClassPathResource("static/sql/schema-h2.sql");
            Resource initData = new ClassPathResource("static/sql/data-h2.sql");
            DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema, initData);
            DatabasePopulatorUtils.execute(databasePopulator, dataSource);
        } catch (Exception ex) {
            // TODO: use Flyway to manage database migrations to avoid this catch.
        }
        return dataSource;
    }
}
