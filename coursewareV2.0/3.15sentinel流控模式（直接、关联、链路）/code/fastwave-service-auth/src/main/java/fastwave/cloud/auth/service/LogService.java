package fastwave.cloud.auth.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import fastwave.cloud.demo.fastwavelibcommon.R;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Service
public class LogService {

    @SentinelResource(value = "writeLog", blockHandler = "blockHandler")
    public R writeLog(Map<String,Object> params) throws InterruptedException {
        return R.ok("调用成功");
    }

    public R blockHandler(Map<String,Object> params, BlockException ex)
    {
        return R.error("被流量控制");
    }
}
