package com.kafka.productor.Service;


import com.kafka.productor.Model.Reporte;
import com.kafka.productor.Repository.ReporteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;
    @Autowired
    private KafkaTemplate<String, Reporte> kafkaTemplate;

    private static final String Topic = "TopicPatron4";
    public void createReport(Reporte reporte){

        reporte.setId(UUID.randomUUID().toString());
        reporte.setEstado("PENDIENTE");
        reporteRepository.save(reporte);
    }

    public void reportGenerate() {
        List<Reporte> reportes = reporteRepository.buscarEstado("PENDIENTE");
        for (Reporte reporte : reportes){
                kafkaTemplate.send(Topic,reporte.getId(), reporte);
                reporte.setEstado("EN COLA");
                reporteRepository.save(reporte);
        }
    }
}
