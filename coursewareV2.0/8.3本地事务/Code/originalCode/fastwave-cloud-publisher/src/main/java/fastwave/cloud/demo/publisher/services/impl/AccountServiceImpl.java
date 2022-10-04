package fastwave.cloud.demo.publisher.services.impl;

import fastwave.cloud.demo.publisher.dao.AccountDao;
import fastwave.cloud.demo.publisher.dao.TransDao;
import fastwave.cloud.demo.publisher.domain.AccountDO;
import fastwave.cloud.demo.publisher.domain.TransDO;
import fastwave.cloud.demo.publisher.services.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Resource
    private TransDao transDao;

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
    @Transactional
    public String transfer(Integer id1, Integer id2, float amount)
    {
//        try {
            //扣减
            AccountDO user1 = accountDao.get(id1);
            user1.setBalance(user1.getBalance() - amount);
            accountDao.update(user1);

            //增加
            AccountDO user2 = accountDao.get(id2);
            user2.setBalance(user2.getBalance() + amount);
            accountDao.update(user2);

            //流水日志
            TransDO transDO = new TransDO();
            transDO.setId(UUID.randomUUID().toString());
            transDO.setStatus(1);
            transDao.save(transDO);

            return "转账成功";
//        }catch (Exception e)
//        {
//            return "转账失败";
//        }
    }
}
