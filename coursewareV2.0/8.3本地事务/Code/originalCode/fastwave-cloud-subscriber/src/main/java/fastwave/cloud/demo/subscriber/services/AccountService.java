package fastwave.cloud.demo.subscriber.services;

import fastwave.cloud.demo.subscriber.domain.AccountDO;

import java.util.List;
import java.util.Map;

public interface AccountService {

    AccountDO get(Integer id);

    List<AccountDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(AccountDO bed);

    int update(AccountDO bed);

    int remove(Integer id);

    int batchRemove(Integer[] ids);

    String transfer(Integer id1, Integer id2, float amount);
}
