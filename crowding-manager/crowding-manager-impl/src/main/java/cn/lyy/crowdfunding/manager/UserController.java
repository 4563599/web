package cn.lyy.crowdfunding.manager;

import cn.lyy.crowdfunding.bean.User;
import cn.lyy.crowdfunding.manager.service.UserService;
import cn.lyy.utils.AjaxResult;
import cn.lyy.utils.Page;
import cn.lyy.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.krb5.internal.PAData;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/toIndex")
    public String toIndex(){
        return "user/index";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "user/add";
    }


    @RequestMapping("/doDelete")
    @ResponseBody
    public Object doDelete(Integer id){
        AjaxResult ajaxResult = new AjaxResult();

        try {
            int count = userService.deleteUserById(id);
            ajaxResult.setSuccess(count==1);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("修改数据失败");
        }
        return ajaxResult;
    }

    @RequestMapping("/doDeleteBatch")
    @ResponseBody
    public Object doDeleteBatch(Integer[] id){
        AjaxResult ajaxResult = new AjaxResult();

        try {
            int count = userService.deleteUsers(id);
            ajaxResult.setSuccess(count==id.length);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("修改数据失败");
        }
        return ajaxResult;
    }


    @RequestMapping("/toUpdate")
    public String toUpdate(Integer id,Map map){

        User user = userService.getUserById(id);
        map.put("user", user);

        return "user/update";
    }

    @RequestMapping("/doUpdate")
    @ResponseBody
    public Object doUpdate(User user){
        AjaxResult ajaxResult = new AjaxResult();

        try {
            int count = userService.updateUserById(user);
            ajaxResult.setSuccess(count==1);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("修改数据失败");
        }
        return ajaxResult;
    }

    @RequestMapping("/doAdd")
    @ResponseBody
    public Object doAdd(User user){
        AjaxResult ajaxResult = new AjaxResult();

        try {
            int count = userService.saveUser(user);
            ajaxResult.setSuccess(count==1);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("查询数据失败");
        }
        return ajaxResult;
    }


    //异步条件查询
    @RequestMapping("/index")
    @ResponseBody
    public Object toindex(@RequestParam(value = "pageno", defaultValue = "1", required = false) Integer pageno, @RequestParam(value = "pagesize", defaultValue = "10", required = false) Integer pagesize, String queryText) {
        AjaxResult ajaxResult = new AjaxResult();

        try {
            Map paramMap = new HashMap();
            paramMap.put("pageno",pageno);
            paramMap.put("pagesize",pagesize);

            if (!StringUtil.isEmpty(queryText)) {
                paramMap.put("queryText",queryText);
            }
            Page page = userService.queryUserByPage(paramMap);
            ajaxResult.setSuccess(true);
            ajaxResult.setPage(page);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("查询数据失败");
        }
        return ajaxResult;
    }

//    @RequestMapping("/index")
//    @ResponseBody
//    public Object toindex(@RequestParam(value = "pageno", defaultValue = "1", required = false) Integer pageno, @RequestParam(value = "pagesize", defaultValue = "10", required = false) Integer pagesize) {
//        AjaxResult ajaxResult = new AjaxResult();
//
//        try {
//            Page page = userService.queryUserByPage(pageno, pagesize);
//            ajaxResult.setSuccess(true);
//            ajaxResult.setPage(page);
//        } catch (Exception e) {
//            e.printStackTrace();
//            ajaxResult.setSuccess(false);
//            ajaxResult.setMessage("查询数据失败");
//        }
//        return ajaxResult;
//    }


//同步请求
//    @RequestMapping("index")
//    public String index(@RequestParam(value = "pageno", defaultValue = "1", required = false) Integer pageno, @RequestParam(value = "pagesize", defaultValue = "10", required = false) Integer pagesize, Map map) {
//        Page page = userService.queryUserByPage(pageno, pagesize);
//        map.put("page", page);
//        return "user/index";
//    }
}
