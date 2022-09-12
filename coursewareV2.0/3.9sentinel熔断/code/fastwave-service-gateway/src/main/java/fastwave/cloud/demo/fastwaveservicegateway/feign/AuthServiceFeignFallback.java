package fastwave.cloud.demo.fastwaveservicegateway.feign;

import fastwave.cloud.demo.fastwavelibcommon.R;
import fastwave.cloud.demo.fastwaveservicegateway.feign.AuthServiceFeign;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AuthServiceFeignFallback implements AuthServiceFeign {
    @Override
    public R byFeignGet(Map<String, Object> params) {
        return R.error("sentinel byFeignGet 降级了！");
    }

    @Override
    public R byFeignPost(Map<String, Object> params) {
        return R.error("sentinel byFeignPost 降级了！");
    }
}
