package fastwave.cloud.auth;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 当使用@SentinelResource注解时，必须声名该Bean
     */
    @Bean
    public SentinelResourceAspect sentinelResourceAspect()
    {
        return new SentinelResourceAspect();
    }

}
