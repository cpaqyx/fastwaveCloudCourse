package fastwave.cloud.auth.controller.flow;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import fastwave.cloud.demo.fastwavelibcommon.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/* 测试地址：
http://localhost:8082/flowRef/readOrder?token=123456
http://localhost:8082/flowRef/createOrder?token=1234569
 */
@RestController
@RequestMapping("/flowRef")
public class FlowRefController {
     /**
     * 当该接口出现流控时，则关联的资源不可用
     */
     @GetMapping("/createOrder")
    public R flowApiByAnnotation(@RequestParam Map<String,Object> params) throws InterruptedException {
        return hasPermission(params);
    }

    /**
     * 相关联的资源受到影响
     */
    @GetMapping("/readOrder")
    public R readOrder(@RequestParam Map<String,Object> params) throws InterruptedException {
        return hasPermission(params);
    }

    /**
     * 需保护的业务逻辑代码
     */
    private R hasPermission(@RequestParam Map<String,Object> params) throws InterruptedException {
        Object token = params.get("token");
        if(token != null && token.toString().length() > 10)
        {
            int a = 1/0;
        }
        if(token != null && token.toString().length() > 5)
        {
            return R.ok("验证成功");
        }

        return R.error("验证失败");
    }
}
