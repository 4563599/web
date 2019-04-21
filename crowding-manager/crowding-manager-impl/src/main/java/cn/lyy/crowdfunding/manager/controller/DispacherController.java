package cn.lyy.crowdfunding.manager.controller;

import cn.lyy.crowdfunding.bean.User;
import cn.lyy.crowdfunding.manager.service.UserService;
import cn.lyy.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DispacherController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }


    @RequestMapping("/doLogin")
    public String doLogin(String loginacct, String userpswd, String type, HttpSession httpSession) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("loginacct", loginacct);
        paramMap.put("userpswd", userpswd);
        paramMap.put("type", type);
        User user = userService.login(paramMap);
        httpSession.setAttribute(Const.LOGIN_USER, user);
        return "redirect:/main.htm";
    }
}
