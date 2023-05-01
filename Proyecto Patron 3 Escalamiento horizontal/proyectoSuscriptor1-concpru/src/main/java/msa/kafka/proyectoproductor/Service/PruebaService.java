package msa.kafka.proyectoproductor.Service;

import lombok.extern.slf4j.Slf4j;
import msa.kafka.proyectoproductor.Model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
@Slf4j
public class PruebaService {

@Autowired
private ExecutorService executorService;


    int contador = 0;
    @Async
    public Future<String> leerMsg (Persona persona) {

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
        try {

            log.info(contador + " . Consumed JSON Message: " + persona);
            Thread.sleep(1000 * 20);
            contador++;
            log.info("sale del proceso" + persona.getEdad());

        }catch (Exception ex) {
            ex.printStackTrace();

        }
         return "200";
        } );

        return completableFuture;
    }

}
