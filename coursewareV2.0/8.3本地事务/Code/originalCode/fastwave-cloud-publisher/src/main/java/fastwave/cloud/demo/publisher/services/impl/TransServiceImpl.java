package fastwave.cloud.demo.publisher.services.impl;

import fastwave.cloud.demo.publisher.dao.TransDao;
import fastwave.cloud.demo.publisher.domain.TransDO;
import fastwave.cloud.demo.publisher.services.TransService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class TransServiceImpl implements TransService {
    @Resource
    private TransDao transDao;

    @Override
    public TransDO get(String id){
        return transDao.get(id);
    }

    @Override
    public List<TransDO> list(Map<String, Object> map){
        return transDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return transDao.count(map);
    }

    @Override
    public int save(TransDO trans){
        return transDao.save(trans);
    }

    @Override
    public int update(TransDO trans){
        return transDao.update(trans);
    }

    @Override
    public int remove(String id){
        return transDao.remove(id);
    }

    @Override
    public int batchRemove(String[] ids){
        return transDao.batchRemove(ids);
    }
}
