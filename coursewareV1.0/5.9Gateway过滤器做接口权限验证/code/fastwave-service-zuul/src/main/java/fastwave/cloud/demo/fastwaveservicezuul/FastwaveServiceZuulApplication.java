package fastwave.cloud.demo.fastwaveservicezuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class FastwaveServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastwaveServiceZuulApplication.class, args);
    }
}
