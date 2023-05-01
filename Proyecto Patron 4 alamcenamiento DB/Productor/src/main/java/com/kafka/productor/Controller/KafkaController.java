package com.kafka.productor.Controller;



import com.kafka.productor.Model.Reporte;
import com.kafka.productor.Service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/api/")
public class KafkaController {

    @Autowired
    private ReporteService reporteService;

    @PostMapping(value = "/mensaje")
    public String mensaje (@RequestBody Reporte reporte) {
        try{
            reporteService.createReport(reporte);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return ("200");
    }
}
