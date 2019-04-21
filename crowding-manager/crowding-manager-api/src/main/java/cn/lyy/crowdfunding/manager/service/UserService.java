package cn.lyy.crowdfunding.manager.service;

import cn.lyy.crowdfunding.bean.User;

import java.util.Map;

public interface UserService {

    User login(Map<String, Object> paramMap);
}
