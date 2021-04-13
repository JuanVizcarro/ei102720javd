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
import proyectoSANA.dao.MunicipioRowMapper;
import proyectoSANA.model.Municipio;

@SpringBootApplication
public class SANA_Application implements CommandLineRunner {
    private static final Logger log = Logger.getLogger(SANA_Application.class.getName());

    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        // Auto-configura l'aplicació
        new SpringApplicationBuilder(SANA_Application.class).run(args);
    }

    // Funció principal
    public void run(String... strings) throws Exception {
        log.info("Ací va el meu codi");

        log.info("Selecciona la nadadora Gemma Mengual");
        Municipio m1 = jdbcTemplate.queryForObject(
                "SELECT * FROM Municipio where nombre = 'Castellon'",
                new MunicipioRowMapper());
        log.info(m1.toString());
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

