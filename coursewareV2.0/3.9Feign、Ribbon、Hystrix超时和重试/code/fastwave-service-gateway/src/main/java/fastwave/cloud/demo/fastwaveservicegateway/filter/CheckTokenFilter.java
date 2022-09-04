package fastwave.cloud.demo.fastwaveservicegateway.filter;

import fastwave.cloud.demo.fastwavelibcommon.R;
import fastwave.cloud.demo.fastwaveservicegateway.feign.AuthServiceFeign;
import fastwave.cloud.demo.fastwaveservicegateway.httpClient.AuthServiceByHttp;
import fastwave.cloud.demo.fastwaveservicegateway.restTempate.AuthServiceByTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

// localhost:8085/checkToken/byFeignPost?token=123
@RestController
@RequestMapping("/checkToken")
public class CheckTokenFilter {

    @Autowired
    AuthServiceByHttp authServiceByHttp;

    @Autowired
    AuthServiceByTemplate authServiceByTemplate;

    @Resource
    AuthServiceFeign authServiceFeign;

    @GetMapping("/byHttpGet")
    public R byHttpGet(@RequestParam Map<String, Object> params)
    {
        return authServiceByHttp.byHttpGet(params);
    }

    @GetMapping("/byHttpPost")
    public R byHttpPost(@RequestParam Map<String, Object> params)
    {
        return authServiceByHttp.byHttpPost(params);
    }

    @GetMapping("/byTemplate")
    public R byTemplate(@RequestParam Map<String, Object> params)
    {
        return authServiceByTemplate.byTemplate(params);
    }

    @GetMapping("/byBalancer")
    public R byBalancer(@RequestParam Map<String, Object> params)
    {
        return authServiceByTemplate.byBalancer(params);
    }

    @GetMapping("/byBalancerBetter")
    public R byBalancerBetter(@RequestParam Map<String, Object> params)
    {
        return authServiceByTemplate.byBalancerBetter(params);
    }
    @GetMapping("/byHystrix")
    public R byHystrix(@RequestParam Map<String, Object> params)
    {
        return authServiceByTemplate.byHystrix(params);
    }

    @GetMapping("/byFeignGet")
    public R byFeignGet(@RequestParam Map<String, Object> params)
    {
        return authServiceFeign.byFeignGet(params);
    }

    @GetMapping("/byFeignPost")
    public R byFeignPost(@RequestParam Map<String, Object> params)
    {
        return authServiceFeign.byFeignPost(params);
    }


}
