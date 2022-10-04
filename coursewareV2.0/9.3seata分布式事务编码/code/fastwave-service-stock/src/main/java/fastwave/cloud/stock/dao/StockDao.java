package fastwave.cloud.stock.dao;

import fastwave.cloud.stock.domain.StockDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StockDao {
    StockDO get(String id);

    List<StockDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(StockDO StockDO);

    int update(StockDO StockDO);

    int remove(String id);

    int batchRemove(String[] ids);
}
