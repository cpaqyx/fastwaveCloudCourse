package fastwave.cloud.fastwaveserviceauth.controller;

import fastwave.cloud.demo.fastwavelibcommon.R;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/hasPermission")
    public R hasPermission(@RequestParam Map<String,Object> params) throws Exception {
        Object token = params.get("token");
        if(token != null && token.toString().length() > 10)
        {
            throw new Exception("出现异常了");
        }
        if(token != null && token.toString().length() > 5)
        {
            return R.ok("验证成功");
        }

        return R.error("验证失败");
    }

    static int times = 0;
    @PostMapping("/hasPermission")
    public R hasPermissionByPost(@RequestBody Map<String,Object> params) throws InterruptedException {
        Object token = params.get("token");
        if(token != null && token.toString().length() > 5)
        {
            return R.ok("验证成功");
        }

        if(times++ % 2 == 0) {
            //throw new InterruptedException("出错了");
            Thread.sleep(2000L);
        }
        else
        {
            Thread.sleep(3000L);
        }

       return R.error("验证失败");
    }
}
