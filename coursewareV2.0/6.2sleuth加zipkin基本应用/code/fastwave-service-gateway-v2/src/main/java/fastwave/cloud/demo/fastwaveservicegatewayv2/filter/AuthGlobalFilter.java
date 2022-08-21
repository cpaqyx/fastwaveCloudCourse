package fastwave.cloud.demo.fastwaveservicegatewayv2.filter;

import fastwave.cloud.demo.fastwavelibcommon.R;
import fastwave.cloud.demo.fastwaveservicegatewayv2.feign.AuthServiceFeign;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

//@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Resource
    AuthServiceFeign authServiceFeign;

    @Value("${server.port}")
    Integer port;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst("token");
        String url = exchange.getRequest().getURI().getPath();

        if (token != null && !token.isEmpty())
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("token", token);
            R r = authServiceFeign.byFeignPost(params);
            if(r.isSuccess())
            {
                return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                }));
            }
        }

        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }

    @Override
    public int getOrder() {
        return -100;
    }
}
