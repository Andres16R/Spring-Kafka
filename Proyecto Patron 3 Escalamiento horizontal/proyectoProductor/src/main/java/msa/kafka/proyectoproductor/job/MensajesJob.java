package msa.kafka.proyectoproductor.job;



import msa.kafka.proyectoproductor.Model.Persona;
import msa.kafka.proyectoproductor.Service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service

public class MensajesJob {
	
    @Autowired
    private ProducerService producerService;
    
    int count = 0;
    
    Persona persona = new Persona();
    
    @Scheduled(fixedDelay = 200)
    public void generarMensajes() {
        if(count < 100) {
            try{
                persona.setId(String.valueOf(count));
                persona.setEdad(count);
                persona.setNombre("Maicol" + count);
                persona.setCorreo("maicol" + count + "@maicol.com");
                count++;
                producerService.enviarMsg(persona);
                System.out.println("Enviado" + persona.getNombre());
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }


    }

}
