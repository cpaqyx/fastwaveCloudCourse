package fastwave.cloud.demo.fastwaveservicegateway.filter;

import fastwave.cloud.demo.fastwavelibcommon.R;
import fastwave.cloud.demo.fastwaveservicegateway.httpClient.AuthServiceByHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/checkToken")
public class CheckTokenFilter {

    @Autowired
    AuthServiceByHttp authServiceByHttp;

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
}
