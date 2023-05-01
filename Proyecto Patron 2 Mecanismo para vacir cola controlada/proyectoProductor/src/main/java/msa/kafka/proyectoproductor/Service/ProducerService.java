package msa.kafka.proyectoproductor.Service;

import msa.kafka.proyectoproductor.Model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, Persona> kafkaTemplate;

    private static final String TOPIC = "TopicPatron2";

    public String enviarMsg (Persona persona){
        try{
            persona.setId(UUID.randomUUID().toString());
            kafkaTemplate.send(TOPIC, persona.getId() , persona);
            return ("true");
        }catch (Exception ex) {
            ex.printStackTrace();
            return ("false");
        }


    }


}
