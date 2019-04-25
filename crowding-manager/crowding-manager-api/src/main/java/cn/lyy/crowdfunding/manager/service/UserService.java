package cn.lyy.crowdfunding.manager.service;

import cn.lyy.crowdfunding.bean.User;
import cn.lyy.utils.Page;

import java.util.Map;

public interface UserService {

    User login(Map<String, Object> paramMap);

    Page queryUserByPage(Integer pageno, Integer pagesize);

}
