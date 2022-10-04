package fastwave.cloud.demo.publisher.dao;

import fastwave.cloud.demo.publisher.domain.AccountDO;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountDao {
    AccountDO get(Integer id);

    List<AccountDO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(AccountDO accountDO);

    int update(AccountDO accountDO);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
