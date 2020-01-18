package fastwave.cloud.demo.fastwaveservicegatewayv2.feign;

import fastwave.cloud.demo.fastwavelibcommon.R;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AuthServiceHystrix implements AuthServiceFeign {
    @Override
    public R byFeignGet(Map<String, Object> params) {
        return R.error("服务正忙，请稍后重试，byFeignGet");
    }

    @Override
    public R byFeignPost(Map<String, Object> params) {
        return R.error("服务正忙，请稍后重试，byFeignPost");
    }
}
