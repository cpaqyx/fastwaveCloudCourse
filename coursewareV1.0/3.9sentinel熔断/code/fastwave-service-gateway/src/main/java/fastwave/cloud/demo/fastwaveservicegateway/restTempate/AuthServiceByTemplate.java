package fastwave.cloud.demo.fastwaveservicegateway.restTempate;

import com.alibaba.fastjson.JSON;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import fastwave.cloud.demo.fastwavelibcommon.R;
import fastwave.cloud.demo.fastwavelibcommon.ServiceName;
import fastwave.cloud.demo.fastwaveservicegateway.httpClient.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class AuthServiceByTemplate {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate singleTestTemplate;

    public R byTemplate(@RequestParam Map<String, Object> params)
    {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://localhost:8082/auth/hasPermission", params, R.class);
    }

    public R byBalancer(@RequestParam Map<String, Object> params)
    {
        ServiceInstance instance = loadBalancerClient.choose("services-auth");
        String ip = instance.getHost();
        Integer port = instance.getPort();
        String url = String.format("http://%s:%d/auth/hasPermission", ip, port);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url, params, R.class);
    }

    public R byBalancerBetter(@RequestParam Map<String, Object> params)
    {
        String url = String.format("http://%s/auth/hasPermission", ServiceName.SERVICE_AUTH);
        return singleTestTemplate.postForObject(url, params, R.class);
    }

    //@HystrixCommand(fallbackMethod = "getError")
    public R byHystrix(@RequestParam Map<String, Object> params)
    {
        String url = String.format("http://%s/auth/hasPermission", ServiceName.SERVICE_AUTH);
        return singleTestTemplate.postForObject(url, params, R.class);
    }

    public R getError(@RequestParam Map<String, Object> params)
    {
        return R.error("服务正忙，请稍后重试");
    }
}

