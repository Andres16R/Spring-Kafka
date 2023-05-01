package msa.kafka.proyectoproductor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProyectoProductorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoProductorApplication.class, args);
    }

}
