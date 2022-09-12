package fastwave.cloud.auth.config;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SentinelConfig  implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        // 流控 #####################################
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("flowApi");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 1.
        rule.setCount(1);
        rules.add(rule);

        FlowRule rule2 = new FlowRule();
        rule2.setResource("flowApiByAnnotation");
        rule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 1.
        rule2.setCount(1);
        rules.add(rule2);

        FlowRuleManager.loadRules(rules);


        // 降级#####################################
        DegradeRule degradeRule = new DegradeRule();
        degradeRule.setResource("degradeApi");

        // 异常数量来作为熔断依据
        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);

        // 统计时长(滚动窗口)
        degradeRule.setStatIntervalMs(30000);

        // 最小请求数量
        degradeRule.setMinRequestAmount(2);

        // 触发熔断异常数量
        degradeRule.setCount(2);

        // 发生熔断后，持续的时长
        degradeRule.setTimeWindow(10);

        List<DegradeRule> degradeRules = new ArrayList<DegradeRule>();
        degradeRules.add(degradeRule);

        DegradeRuleManager.loadRules(degradeRules);
    }
}
