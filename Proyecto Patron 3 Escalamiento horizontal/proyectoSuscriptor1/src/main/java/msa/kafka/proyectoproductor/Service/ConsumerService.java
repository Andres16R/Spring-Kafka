package msa.kafka.proyectoproductor.Service;


import msa.kafka.proyectoproductor.Model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class ConsumerService {

    @Autowired
    private AsyncService asyncService;
    int contador = 0;

    public void leer (Persona persona){
        //  log.info("leer " + persona);

        List<Future<String>> listTask = new ArrayList<Future<String>>();

        listTask.add(asyncService.leerMsg2(persona));


        listTask.forEach( future -> {
            try{
                future.get();
            }catch (InterruptedException | ExecutionException e){
                e.printStackTrace();
            }
        });


    }


//, properties = {"enable.auto.commit:True"}

    @KafkaListener (topics = "prueba10-1", groupId = "Suscriptor10", concurrency = "10" ,
            properties = {"session.timeout.ms:60000"})

    public Boolean consumeJson1(Persona persona, Acknowledgment acknowledgment) {

        try {
            leer(persona);
            acknowledgment.acknowledge();
            log.info("Commit: " + persona.getEdad());

            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }




        //log.info("KAFKA: " + persona);
//        try {
//            log.info("1 . Consumed JSON Message: " + persona);
//            Thread.sleep(1000 * 10);
//            contador++;
//            System.out.println("sale consulta 1 " + "Total : "+ contador);
//
//            return (true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return (false);
    }



}
