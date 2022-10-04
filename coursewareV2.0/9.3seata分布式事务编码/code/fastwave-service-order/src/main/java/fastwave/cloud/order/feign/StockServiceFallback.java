package fastwave.cloud.order.feign;

import fastwave.cloud.demo.fastwavelibcommon.R;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class StockServiceFallback implements StockServiceFeign {
    @Override
    public R update(Map<String, Object> params) {
        return R.error("服务正忙，请稍后重试");
    }
}
