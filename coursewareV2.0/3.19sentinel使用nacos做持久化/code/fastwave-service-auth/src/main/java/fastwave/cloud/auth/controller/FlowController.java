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
http://localhost:8082/auth/flowApi?token=1234569
http://localhost:8082/auth/flowApi?token=123456911111111111

配置规则：
[{
	"clusterMode": false,
	"controlBehavior": 0,
	"count": 1,
	"grade": 1,
	"limitApp": "default",
	"resource": "/auth/flowApi",
	"strategy": 0
}]
 */
@RestController
@RequestMapping("/auth")
public class FlowController {

    @GetMapping("/flowApi")
    public R degradeApi(@RequestParam Map<String,Object> params) {
        Object token = params.get("token");
        if(token != null && token.toString().length() > 5)
        {
            return R.ok("验证成功");
        }

        return R.error("验证失败");
    }
}
