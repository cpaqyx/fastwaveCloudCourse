package fastwave.cloud.demo.fastwaveservicegatewayv2.feign;

import fastwave.cloud.demo.fastwavelibcommon.R;
import fastwave.cloud.demo.fastwavelibcommon.ServiceName;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = ServiceName.SERVICE_AUTH, fallback = AuthServiceHystrix.class)
public interface AuthServiceFeign {
    @GetMapping("/auth/hasPermission")
    R byFeignGet(@RequestParam Map<String, Object> params);

    @PostMapping("/auth/hasPermission")
    R byFeignPost(@RequestBody Map<String, Object> params);
}
