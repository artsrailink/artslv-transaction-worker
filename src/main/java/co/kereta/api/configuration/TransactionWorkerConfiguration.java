package co.kereta.api.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by gemuruhgeo on 20/09/16.
 */
@Configuration
public class TransactionWorkerConfiguration {
    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
