package fastwave.cloud.stock.controller;

import fastwave.cloud.demo.fastwavelibcommon.R;
import fastwave.cloud.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 测试地址：
 * http://localhost:8082/stock/update?productId=001&count=2
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping("/update")
    public R hasPermission(@RequestParam Map<String,Object> params) {
        return stockService.updateStock(params);
    }
}
