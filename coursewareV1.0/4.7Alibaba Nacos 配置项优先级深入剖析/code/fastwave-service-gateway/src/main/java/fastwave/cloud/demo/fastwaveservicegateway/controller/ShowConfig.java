package fastwave.cloud.demo.fastwaveservicegateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ShowConfig {

    @Value("${custom.pic.path}")
    String path;

    @Value("${logging.level.root}")
    String level;

    @GetMapping("/showConfig")
    public String showConfig()
    {
        return "获取到文件存放的路径是：" + path
                + "，日志级别是：" + level;
    }
}
