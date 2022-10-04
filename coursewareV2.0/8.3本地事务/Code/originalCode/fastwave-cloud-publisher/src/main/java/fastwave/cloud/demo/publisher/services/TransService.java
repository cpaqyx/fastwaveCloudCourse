package fastwave.cloud.demo.publisher.services;

import fastwave.cloud.demo.publisher.domain.TransDO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface TransService {

    TransDO get(String id);

    List<TransDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(TransDO bed);

    int update(TransDO bed);

    int remove(String id);

    int batchRemove(String[] ids);
}
