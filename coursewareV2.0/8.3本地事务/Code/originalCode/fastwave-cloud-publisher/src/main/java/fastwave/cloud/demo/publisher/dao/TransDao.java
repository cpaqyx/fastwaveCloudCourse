package fastwave.cloud.demo.publisher.dao;

import fastwave.cloud.demo.publisher.domain.TransDO;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TransDao {
    TransDO get(String id);

    List<TransDO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(TransDO transDO);

    int update(TransDO transDO);

    int remove(String id);

    int batchRemove(String[] ids);
}
