package fastwave.cloud.demo.fastwaveservicegatewayv2.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.rewrite.ModifyResponseBodyGatewayFilterFactory;
import org.springframework.http.codec.ServerCodecConfigurer;

public class RewriteFilter extends ModifyResponseBodyGatewayFilterFactory {
    public RewriteFilter(ServerCodecConfigurer codecConfigurer) {
        super(codecConfigurer);
    }

    /*@Override
    public GatewayFilter apply(Object config) {

        return new ModifyResponseGatewayFilter(this.getConfig());
    }

    private Config getConfig() {
        Config cf = new Config();
        //cf.setRewriteFunction()
    }*/
}
