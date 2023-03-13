package ch.ps_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("ch.ps_backend.repository")
public class PsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PsBackendApplication.class, args);
    }

}
