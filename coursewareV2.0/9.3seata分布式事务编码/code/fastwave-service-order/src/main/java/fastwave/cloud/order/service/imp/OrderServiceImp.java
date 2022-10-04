package fastwave.cloud.order.service.imp;

import fastwave.cloud.demo.fastwavelibcommon.R;
import fastwave.cloud.order.dao.OrderDao;
import fastwave.cloud.order.domain.OrderDO;
import fastwave.cloud.order.feign.StockServiceFeign;
import fastwave.cloud.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class OrderServiceImp implements OrderService {

    @Resource
    StockServiceFeign StockServiceFeign;

    @Resource
    OrderDao OrderDao;

    @Override
    @GlobalTransactional
    public R createOrder(Map<String, Object> params) throws Exception {

        // 创建订单
        OrderDO orderDO = new OrderDO();
        orderDO.setName(params.get("orderName").toString());
        orderDO.setBalance(Float.parseFloat(params.get("amount").toString()));
        OrderDao.save(orderDO);

        // 扣减库存
        R stockResult = StockServiceFeign.update(params);
        if(!stockResult.isOk())
        {
            throw new Exception("库存不足");
        }

        return R.ok("订单创建成功");
    }
}
