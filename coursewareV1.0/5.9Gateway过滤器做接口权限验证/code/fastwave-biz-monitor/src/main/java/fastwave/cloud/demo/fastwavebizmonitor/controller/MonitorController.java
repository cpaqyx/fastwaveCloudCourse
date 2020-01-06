package fastwave.cloud.demo.fastwavebizmonitor.controller;

import fastwave.cloud.demo.fastwavelibcommon.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/monitor")
public class MonitorController {

    @GetMapping("/list")
    public R hasPermission(@RequestParam Map<String,Object> params)
    {
        R r = R.ok("数据获取正常");
        r.put("count", "10件");
        r.put("status", "正常");
        return r;
    }
}
