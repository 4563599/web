package cn.lyy.crowdfunding.manager.service.impl;

import cn.lyy.crowdfunding.manager.dao.TestDao;
import cn.lyy.crowdfunding.manager.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;

    @Override
    public void insert() {
        Map map = new HashMap();
        map.put("username", "zhangsan");
        testDao.insert(map);
    }
}
