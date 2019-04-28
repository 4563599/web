package cn.lyy.crowdfunding.manager;

import cn.lyy.crowdfunding.manager.service.UserService;
import cn.lyy.utils.AjaxResult;
import cn.lyy.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/index")
    @ResponseBody
    public Object toindex(@RequestParam(value = "pageno", defaultValue = "1", required = false) Integer pageno, @RequestParam(value = "pagesize", defaultValue = "10", required = false) Integer pagesize) {
        AjaxResult ajaxResult = new AjaxResult();

        try {
            Page page = userService.queryUserByPage(pageno, pagesize);
            ajaxResult.setSuccess(true);
            ajaxResult.setPage(page);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("查询数据失败");
        }
        return ajaxResult;
    }

    @RequestMapping("/toindex")
    public String toIndex(){
        return "user/index";
    }

//同步请求
//    @RequestMapping("index")
//    public String index(@RequestParam(value = "pageno", defaultValue = "1", required = false) Integer pageno, @RequestParam(value = "pagesize", defaultValue = "10", required = false) Integer pagesize, Map map) {
//        Page page = userService.queryUserByPage(pageno, pagesize);
//        map.put("page", page);
//        return "user/index";
//    }
}
