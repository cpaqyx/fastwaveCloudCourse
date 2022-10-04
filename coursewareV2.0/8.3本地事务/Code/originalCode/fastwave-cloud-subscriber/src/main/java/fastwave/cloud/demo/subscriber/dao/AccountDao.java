package fastwave.cloud.demo.subscriber.dao;

import fastwave.cloud.demo.subscriber.domain.AccountDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AccountDao {
    AccountDO get(Integer id);

    List<AccountDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(AccountDO bed);

    int update(AccountDO bed);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
