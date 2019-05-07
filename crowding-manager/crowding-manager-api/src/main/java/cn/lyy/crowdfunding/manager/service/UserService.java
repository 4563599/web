package cn.lyy.crowdfunding.manager.service;

import cn.lyy.crowdfunding.bean.User;
import cn.lyy.utils.Page;
import cn.lyy.vo.Data;

import java.util.Map;

public interface UserService {

    User login(Map<String, Object> paramMap);

//    @Deprecated
//    Page queryUserByPage(Integer pageno, Integer pagesize);

    int saveUser(User user);

    Page queryUserByPage(Map<String,Object> paramMap);

    User getUserById(Integer id);

    int updateUserById(User id);

    int deleteUserById(Integer id);

    int deleteUsers(Integer[] ids);

    int deleteUsersByvo(Data data);
}
