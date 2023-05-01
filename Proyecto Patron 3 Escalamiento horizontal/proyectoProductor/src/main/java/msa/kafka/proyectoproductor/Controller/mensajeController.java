package msa.kafka.proyectoproductor.Controller;


import msa.kafka.proyectoproductor.Model.Persona;
import msa.kafka.proyectoproductor.Service.ProducerService;
import msa.kafka.proyectoproductor.job.MensajesJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping (path  = "/api/v1/")
public class mensajeController {

    @Autowired
    private ProducerService producerService;

    @Autowired
    private MensajesJob mensajesJob;

    @PostMapping(value = "enviar/")
    public ResponseEntity<String> enviar (@RequestBody Persona persona){
        try{
            return ResponseEntity.ok(producerService.enviarMsg(persona));
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/iniciar")
    public ResponseEntity<Boolean> iniciar() {
            try {
                mensajesJob.generarMensajes();
                return ResponseEntity.ok(true);
            }catch (Exception ex){
                ex.printStackTrace();
                return ResponseEntity.ok(false);
            }
        }

    }


