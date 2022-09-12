package fastwave.cloud.auth.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import fastwave.cloud.demo.fastwavelibcommon.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* entry风格测试地址：
http://localhost:8082/flow/flowApiBySphU?token=123456

声明风格测试；
http://localhost:8082/flow/flowApiByAnnotation?token=1234569
http://localhost:8082/flow/flowApiByAnnotation?token=123456911111111111

 */
@RestController
@RequestMapping("/flow")
public class FlowController {

    /**
     * 外部访问一个被保护的接口，接口代码逻辑与流控代码放到一起，侵入性太强
     */
    @GetMapping("/flowApiBySphU")
    public R flowApiBySphU(@RequestParam Map<String, Object> params)
    {
        // 此处的名称resourceApi必须与下initFlowRules中的rule.setResource中设置的名称一致，
        // 最好与@GetMapping("/resourceApi")也一致，但不强制
        try (Entry entry = SphU.entry("flowApi")) {
            // 被保护的逻辑代码或方法
            return hasPermission(params);

        } catch (BlockException | InterruptedException ex) {
            // 处理被流控的逻辑
            return R.error("被流量控制");
        }
    }

    /**
     * 同时满足fallback、blockHandler，则blockHandler优先级更高
     */
    @SentinelResource(value = "flowApiByAnnotation", fallback = "fallback4annotationApi", blockHandler = "blockHandler4annotationApi")
    @GetMapping("/flowApiByAnnotation")
    public R flowApiByAnnotation(@RequestParam Map<String,Object> params) throws InterruptedException {
        return hasPermission(params);
    }

    public R blockHandler4annotationApi(@RequestParam Map<String,Object> params, BlockException ex)
    {
        return R.error("被流量控制");
    }

    public R fallback4annotationApi(Map<String,Object> params, Throwable ex)
    {
        return R.error("异常处理");
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
