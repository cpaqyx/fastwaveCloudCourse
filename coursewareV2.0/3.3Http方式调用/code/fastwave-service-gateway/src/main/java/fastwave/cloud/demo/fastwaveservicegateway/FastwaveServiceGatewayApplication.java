package fastwave.cloud.demo.fastwaveservicegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FastwaveServiceGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastwaveServiceGatewayApplication.class, args);
    }

}
