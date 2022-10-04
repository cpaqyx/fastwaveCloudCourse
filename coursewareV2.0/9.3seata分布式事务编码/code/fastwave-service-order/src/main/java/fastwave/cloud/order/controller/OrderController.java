package fastwave.cloud.order.controller;

import fastwave.cloud.demo.fastwavelibcommon.R;
import fastwave.cloud.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 测试地址：
 * localhost:8085/order/create?orderName=order1&amount=128.78&productId=001&count=2
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/create")
    public R create(@RequestParam Map<String, Object> params)
    {
        try {
            return orderService.createOrder(params);
        }catch (Exception e)
        {
            return R.error("扣减失败");
        }
    }
}
