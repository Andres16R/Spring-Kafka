package msa.kafka.proyectoproductor.Service;

import lombok.extern.slf4j.Slf4j;
import msa.kafka.proyectoproductor.Model.Persona;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumerService {

    @KafkaListener (topics = "TopicPrueba", groupId = "Susciptor3")
    public void consumeJson(Persona persona) {
        System.out.println("Consumed JSON Message: " + persona);
    }
}
