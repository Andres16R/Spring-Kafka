package msa.kafka.proyectoproductor.Service;

import lombok.extern.slf4j.Slf4j;
import msa.kafka.proyectoproductor.Model.Persona;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
@Slf4j
public class AsyncService {

    int contador = 0;
    @Async
    public Future<String> leerMsg (Persona persona) {

        return CompletableFuture.supplyAsync(() -> {
            try {

                log.info(contador + " . Consumed JSON Message: " + persona);
                Thread.sleep(1000 * 10);
                contador++;
            }catch (Exception ex) {
                ex.printStackTrace();

            }

            log.info("sale del proceso" + persona.getEdad());
            return "200";
        } );
    }



    @Async
    public Future<String> leerMsg2 (Persona persona) {

    log.info("Consume : msg:" + persona.getEdad()+ "  " + persona);
    try {
        Thread.sleep(1000 * 5);
    } catch (Exception ex){
        ex.printStackTrace();

    }
    log.info("Sale del proceso "+ persona.getEdad());
    return  new AsyncResult<String>("200");
    }

}
