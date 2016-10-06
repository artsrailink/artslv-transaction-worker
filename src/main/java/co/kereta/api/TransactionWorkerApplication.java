package co.kereta.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = "co.kereta.api.repository")
@EntityScan(basePackages = "co.kereta.api.entity")
public class TransactionWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionWorkerApplication.class, args);
	}
}
