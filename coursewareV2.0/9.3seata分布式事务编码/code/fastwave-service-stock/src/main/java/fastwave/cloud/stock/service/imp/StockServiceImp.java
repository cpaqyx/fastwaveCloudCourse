package fastwave.cloud.stock.service.imp;

import fastwave.cloud.demo.fastwavelibcommon.R;
import fastwave.cloud.stock.dao.StockDao;
import fastwave.cloud.stock.domain.StockDO;
import fastwave.cloud.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class StockServiceImp implements StockService {

    @Resource
    StockDao stockDao;

    @Override
    public R updateStock(Map<String, Object> params) {

        StockDO stockDO = stockDao.get(params.get("productId").toString());
        int saleStock = Integer.parseInt(params.get("count").toString());
        if(stockDO.getStatus() < saleStock)
        {
            return R.error("库存不足");
        }

        stockDO.setStatus(stockDO.getStatus() - saleStock);
        stockDao.update(stockDO);
        return R.ok("库存扣减成功");
    }
}
