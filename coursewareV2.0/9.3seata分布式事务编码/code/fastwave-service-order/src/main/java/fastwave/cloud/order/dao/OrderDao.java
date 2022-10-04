package fastwave.cloud.order.dao;

import fastwave.cloud.order.domain.OrderDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDao {
    OrderDO get(Integer id);

    List<OrderDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(OrderDO OrderDO);

    int update(OrderDO OrderDO);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
