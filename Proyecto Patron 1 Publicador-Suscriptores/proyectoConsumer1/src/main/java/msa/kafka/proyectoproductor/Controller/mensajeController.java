package msa.kafka.proyectoproductor.Controller;


import msa.kafka.proyectoproductor.Model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping (path  = "/api/v1/")
public class mensajeController {




    @PostMapping(value = "enviar/")
    public ResponseEntity<String> enviar (@RequestBody Persona persona){
        try{
            return null;
            //return ResponseEntity.ok();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


}
