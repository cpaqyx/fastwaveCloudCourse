package fastwave.cloud.fastwaveserviceauth.controller;

import fastwave.cloud.demo.fastwavelibcommon.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Value("${server.port}")
    Integer port;

    static int cnt = 0;

    @GetMapping("/hasPermission")
    public R hasPermission(@RequestParam Map<String,Object> params) throws InterruptedException, UnknownHostException {

        InetAddress address = InetAddress.getLocalHost();
        String ip = address.getHostAddress();
        String serverInfo = String.format("host=%s, port=%d", ip, port);


        Object token = params.get("token");
        if(token != null && token.toString().length() > 5)
        {
            return R.ok("验证成功" + serverInfo);
        }

        Thread.sleep(2000L);
        return R.error("验证失败" + serverInfo);
    }

    @PostMapping("/hasPermission")
    public R hasPermissionByPost(@RequestBody Map<String,Object> params) throws InterruptedException, UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        String ip = address.getHostAddress();
        String serverInfo = String.format("host=%s, port=%d", ip, port);

        Object token = params.get("token");
        if(token != null && token.toString().length() > 5)
        {
            return R.ok("验证成功" + serverInfo);
        }

        //throw new InterruptedException("出错了");
        Thread.sleep(2000L);

       return R.error("验证失败" + serverInfo);
    }
}
