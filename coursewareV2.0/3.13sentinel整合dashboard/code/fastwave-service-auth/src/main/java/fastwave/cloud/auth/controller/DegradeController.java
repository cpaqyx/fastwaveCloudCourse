package fastwave.cloud.auth.controller;

import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import fastwave.cloud.demo.fastwavelibcommon.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* 测试地址：
http://localhost:8082/degrade/degradeApi?token=1234569
http://localhost:8082/degrade/degradeApiByDB?token=123456911111111111
 */
@RestController
@RequestMapping("/degrade")
public class DegradeController {

    /**
     * 同时满足fallback、blockHandler，则blockHandler优先级更高
     */
    @SentinelResource(value = "degradeApi", fallback = "fallback4degradeApi", entryType = EntryType.IN, blockHandler = "blockHandler4degradeApi")
    @GetMapping("/degradeApi")
    public R degradeApi(@RequestParam Map<String,Object> params) throws Exception {
        return hasPermission(params);
    }

    /**
     * 需保护的业务逻辑代码
     */
    private R hasPermission(@RequestParam Map<String,Object> params) throws Exception {
        Object token = params.get("token");
        if(token != null && token.toString().length() > 10)
        {
            throw new Exception("异常");
        }
        if(token != null && token.toString().length() > 5)
        {
            return R.ok("验证成功");
        }

        return R.error("验证失败");
    }

    /**
     * 降级回调
     */
    public R blockHandler4degradeApi(@RequestParam Map<String,Object> params, BlockException ex)
    {
        return R.error("降级处理了");
    }

    /**
     * 异常回调
     */
    public R fallback4degradeApi(Map<String,Object> params, Throwable ex)
    {
        return R.error("异常处理");
    }
}
