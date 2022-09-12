package fastwave.cloud.auth.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import fastwave.cloud.demo.fastwavelibcommon.R;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MySentinelExceptionHandler implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException ex) throws Exception {

        String msg = null;

        if (ex instanceof FlowException) {
            msg = "访问频繁，请稍候再试";

        } else if (ex instanceof DegradeException) {
            msg = "系统降级";
        } else if (ex instanceof SystemBlockException) {
            msg = "系统规则限流或降级";

        } else if (ex instanceof AuthorityException) {
            msg = "授权规则不通过";

        } else {
            msg = "未知限流降级";
        }

        // http状态码
        response.setStatus(500);
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type", "application/json;charset=utf-8");
        response.setContentType("application/json;charset=utf-8");

        response.getWriter().write(R.error(msg).toString());
    }

}


