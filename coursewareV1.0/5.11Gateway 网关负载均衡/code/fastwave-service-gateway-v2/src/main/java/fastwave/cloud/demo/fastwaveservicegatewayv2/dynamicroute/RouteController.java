package fastwave.cloud.demo.fastwaveservicegatewayv2.dynamicroute;

import fastwave.cloud.demo.fastwavelibcommon.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteServices routeServices;

    //增加路由
    @PostMapping("/add")
    public R add(@RequestBody RouteDefinition routeDefinition) {
        try {
            return routeServices.add(routeDefinition);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.error("添加动态路由失败");
    }

    //删除路由
    @DeleteMapping("/routes/{id}")
    public Mono<ResponseEntity<Object>> delete(@PathVariable String id) {
        return routeServices.delete(id);
    }

    //更新路由
    @PostMapping("/update")
    public R update(@RequestBody RouteDefinition definition) {
        return routeServices.update(definition);
    }
}
