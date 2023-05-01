package msa.kafka.proyectoproductor.Service;

import lombok.extern.slf4j.Slf4j;
import msa.kafka.proyectoproductor.Model.Persona;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumerService {
    int contador = 0;



    @KafkaListener (topics = "TopicPatron2",groupId = "Suscriptor1", concurrency = "4")

    public Boolean consumeJson1(Persona persona) {

        try {
            log.info("1 . Consumed JSON Message: " + persona);
            Thread.sleep(1000 * 10);
            contador++;
            System.out.println("sale consulta 1 " + "Total : "+ contador);

            return (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (false);
    }



}
