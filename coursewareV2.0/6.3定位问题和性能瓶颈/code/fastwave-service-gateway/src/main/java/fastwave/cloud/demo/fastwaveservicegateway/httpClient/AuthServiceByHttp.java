package fastwave.cloud.demo.fastwaveservicegateway.httpClient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import fastwave.cloud.demo.fastwavelibcommon.R;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Component
public class AuthServiceByHttp {

    public R byHttpGet(@RequestParam Map<String, Object> params)
    {
        String html = HttpRequestUtil.getData("http://localhost:8082/auth/hasPermission?token=" + params.get("token").toString());
        return JSON.parseObject(html, R.class);
    }

    public R byHttpPost(@RequestBody Map<String, Object> params)
    {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("token", params.get("token").toString());
        String html = HttpRequestUtil.postData("http://localhost:8082/auth/hasPermission", jsonObj);
        return JSON.parseObject(html, R.class);
    }
}
