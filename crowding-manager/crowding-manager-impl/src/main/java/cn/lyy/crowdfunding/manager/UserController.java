package cn.lyy.crowdfunding.manager;

import cn.lyy.crowdfunding.manager.service.UserService;
import cn.lyy.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("index")
    public String index(@RequestParam(value = "pageno", defaultValue = "1", required = false) Integer pageno, @RequestParam(value = "pagesize", defaultValue = "10", required = false) Integer pagesize, Map map) {
        Page page = userService.queryUserByPage(pageno, pagesize);
        map.put("page", page);
        return "user/index";
    }
}
