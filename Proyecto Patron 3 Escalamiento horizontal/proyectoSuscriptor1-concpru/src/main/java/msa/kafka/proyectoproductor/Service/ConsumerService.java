package msa.kafka.proyectoproductor.Service;

import lombok.extern.slf4j.Slf4j;
import msa.kafka.proyectoproductor.Model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class ConsumerService {
    int contador = 0;
    ArrayList<Persona> Mensajes = new ArrayList<>();

@Autowired
private PruebaService pruebaService;

int countMsg = 0;

//public List<Future<String>> leer (Persona persona){
//  //  log.info("leer " + persona);
//
//    List<Future<String>> listTask = new ArrayList<Future<String>>();
//
//      listTask.add(pruebaService.leerMsg(persona));
//
//
//    listTask.forEach( future -> {
//        try{
//            future.get();
//            log.info(future.toString());
//        }catch (InterruptedException | ExecutionException e){
//            e.printStackTrace();
//        }
//    });
//
//
//    return null;
//}

    public String leer (){

        if (countMsg == 10) {
            System.out.println(Mensajes);
            Mensajes.clear();
            countMsg = 0;
        }

        return null;
    }

    @KafkaListener (topics = "prueba10", groupId = "Suscriptor10")
    public String consumeJson1(Persona persona) {
  //      log.info("KAFKA: " + persona);
        try {
        if (countMsg < 10) {

                Mensajes.add(persona);
                countMsg++;

        }else if(countMsg == 10){
            leer();
        }

        TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ("200");

    }



}
