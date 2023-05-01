package com.kafka.consumidor.Service;


import com.kafka.consumidor.Model.Reporte;
import com.kafka.consumidor.Repository.ReporteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;


    @KafkaListener (topics = "TopicPatron4", groupId = "Consumidor1", concurrency = "6")
    public void consumeJson(Reporte reporte) {

        try{
            createReport(reporte);
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    public void createReport(Reporte reporte){

        reporte.setEstado("PROCESADO");
        reporteRepository.save(reporte);
        log.info("Consumed JSON: " + reporte);


    }
}
