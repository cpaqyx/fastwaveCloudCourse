package fastwave.cloud.demo.subscriber.services.impl;


import fastwave.cloud.demo.subscriber.dao.AccountDao;
import fastwave.cloud.demo.subscriber.domain.AccountDO;
import fastwave.cloud.demo.subscriber.services.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public AccountDO get(Integer id){
        return accountDao.get(id);
    }

    @Override
    public List<AccountDO> list(Map<String, Object> map){
        return accountDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return accountDao.count(map);
    }

    @Override
    public int save(AccountDO account){
        return accountDao.save(account);
    }

    @Override
    public int update(AccountDO account){
        return accountDao.update(account);
    }

    @Override
    public int remove(Integer id){
        return accountDao.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids){
        return accountDao.batchRemove(ids);
    }

    @Override
    public String transfer(Integer id1, Integer id2, float amount)
    {
        try {
            //扣减
            AccountDO user1 = accountDao.get(id1);
            user1.setBalance(user1.getBalance() - amount);
            accountDao.update(user1);

            //增加
            AccountDO user2 = accountDao.get(id2);
            user2.setBalance(user2.getBalance() + amount);
            accountDao.update(user2);

            return "转账成功";
        }
        catch (Exception e)
        {
            return "转账失败";
        }
    }
}
