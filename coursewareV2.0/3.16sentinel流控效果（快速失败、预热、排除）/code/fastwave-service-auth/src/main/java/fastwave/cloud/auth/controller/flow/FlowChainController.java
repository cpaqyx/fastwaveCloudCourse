package fastwave.cloud.auth.controller.flow;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import fastwave.cloud.auth.service.LogService;
import fastwave.cloud.demo.fastwavelibcommon.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/* 测试地址：
http://localhost:8082/flowChain/readOrder?token=123456
http://localhost:8082/flowChain/createOrder?token=1234569
 */
@RestController
@RequestMapping("/flowChain")
public class FlowChainController {

    @Autowired
    LogService logService;

     /**
     * 链路1
     */
     @GetMapping("/createOrder")
    public R flowApiByAnnotation(@RequestParam Map<String,Object> params) throws InterruptedException {
         // to do
         // ... 写订单逻辑
        return logService.writeLog(params);
    }

    /**
     * 链路2
     */
    @GetMapping("/readOrder")
    public R readOrder(@RequestParam Map<String,Object> params) throws InterruptedException {
        // to do
        // ... 读订单逻辑
        return logService.writeLog(params);
    }
}
