package fastwave.cloud.demo.fastwaveservicegatewayv2.init;

import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.SentinelGatewayFilter;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class GatewayConfiguration {

    /**
     * 限流出现Block(限制通过)时，调用处理方法，在这里指定返回内容
     * @return 返回对象
     */
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SentinelResponse sentinelGatewayBlockExceptionHandler() {
        return new SentinelResponse();
    }

    /**
     * 配置Sentinel过滤器Bean
     * @return
     */
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public GlobalFilter sentinelGatewayFilter() {
        return new SentinelGatewayFilter();
    }

    /**
     * 在初始化完上面的bean后，会执行该方法
     */
    @PostConstruct
    public void doInit() {
        initGatewayRules();
    }

    /**
     * 配置限流规则
     */
    private void initGatewayRules() {
        Set<GatewayFlowRule> rules = new HashSet<>();
        rules.add(new GatewayFlowRule("path_route_2service")
                .setCount(1) // 限流阈值
                .setIntervalSec(1) // 统计时间窗口，单位是秒，默认是 1 秒
        );
        GatewayRuleManager.loadRules(rules);
    }
}
