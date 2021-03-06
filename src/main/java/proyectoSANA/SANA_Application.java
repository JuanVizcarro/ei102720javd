package proyectoSANA;

import java.util.logging.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import proyectoSANA.controller.SanaException;

@SpringBootApplication
public class SANA_Application implements CommandLineRunner {

    private static final Logger log = Logger.getLogger(SANA_Application.class.getName());

    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        try {
            // Auto-configura l'aplicació
            new SpringApplicationBuilder(SANA_Application.class).run(args);
        } catch (SanaException e){
            throw new SanaException();
        }
    }

    // Funció principal
    public void run(String... strings) throws Exception {
        log.info("Ací va el meu codi");
    }

    // Configura l'accés a la base de dades (DataSource)
    // a partir de les propietats a src/main/resources/applications.properties
    // que comencen pel prefix spring.datasource
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }


}

