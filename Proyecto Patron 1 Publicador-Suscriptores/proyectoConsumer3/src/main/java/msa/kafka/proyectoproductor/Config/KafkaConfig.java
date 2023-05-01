package msa.kafka.proyectoproductor.Config;



import msa.kafka.proyectoproductor.Model.Persona;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    public ConsumerFactory<String, Persona> personaConsumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.242.14.24:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "Susciptor3");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
                new JsonDeserializer<>(Persona.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Persona> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Persona> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(personaConsumerFactory());
        return factory;
    }

}
