package com.kafka.productor.Job;

import com.kafka.productor.Model.Reporte;
import com.kafka.productor.Service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ProductorJob {

    @Autowired
            private ReporteService reporteService;

    int count = 0;
    Reporte reporte = new Reporte();
    @Scheduled (fixedDelay = 200)
    public void generateMsg(){
        if (count < 10) {
            try{
                reporte.setNombre("Maicol: " + count);
                reporte.setMensaje("Msg: " + count);
                count++;
                reporteService.createReport(reporte);
                System.out.println("Enviado" + reporte.getNombre());

            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Scheduled(fixedDelay = 1000 * 20)
    public void reportGenerateAutorizacionesXAutorizador() {
        try {
            reporteService.reportGenerate();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
