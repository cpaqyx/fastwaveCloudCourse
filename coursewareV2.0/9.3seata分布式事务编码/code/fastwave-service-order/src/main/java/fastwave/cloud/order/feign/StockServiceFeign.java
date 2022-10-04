package fastwave.cloud.order.feign;

import fastwave.cloud.demo.fastwavelibcommon.R;
import fastwave.cloud.demo.fastwavelibcommon.ServiceName;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "services-order", fallback = StockServiceFallback.class)
public interface StockServiceFeign {
    @GetMapping("/stock/update")
    R update(@RequestParam Map<String, Object> params);
}
