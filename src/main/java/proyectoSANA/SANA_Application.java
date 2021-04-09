package proyectoSANA;

import java.util.logging.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SANA_Application implements CommandLineRunner {
    private static final Logger log = Logger.getLogger(SANA_Application.class.getName());

    public static void main(String[] args) {
        // Auto-configura l'aplicació
        new SpringApplicationBuilder(SANA_Application.class).run(args);
    }

    // Funció principal
    public void run(String... strings) throws Exception {
        log.info("Ací va el meu codi");
    }
}

