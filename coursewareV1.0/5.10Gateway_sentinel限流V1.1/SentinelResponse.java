package fastwave.cloud.demo.fastwaveservicegatewayv2.init;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;
import org.springframework.http.server.reactive.ServerHttpResponse;

import java.nio.charset.StandardCharsets;

public class SentinelResponse implements WebExceptionHandler {
    @Override
    public Mono<Void> handle(ServerWebExchange serverWebExchange, Throwable throwable) {
        ServerHttpResponse serverHttpResponse = serverWebExchange.getResponse();
        serverHttpResponse.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        byte[] data = "{\"code\":403,\"message\":\"sentinel限流了\"}".getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = serverHttpResponse.bufferFactory().wrap(data);
        return serverHttpResponse.writeWith(Mono.just(buffer));
    }
}
