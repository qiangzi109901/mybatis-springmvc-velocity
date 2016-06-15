package cn.jmo.hello.web;

import cn.jmo.hello.helper.JsonResult;
import cn.jmo.hello.model.UserDO;
import cn.jmo.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiangzi on 16/6/13.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value={"/","/user"})
    public String hello(){
        return "admin/index";
    }


    @RequestMapping("/user/add")
    public String add(){
        return "admin/add";
    }


    @RequestMapping(value = "/user/add",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult add(UserDO user){
        userService.insert(user);
        return new JsonResult(true);
    }


    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult update(UserDO user){
        userService.update(user);
        return new JsonResult(true);
    }


    @RequestMapping(value = "/user/delete",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(Integer id){
        userService.deleteById(id);
        return new JsonResult(true);
    }

    @RequestMapping(value = "/user/pagequery", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult pagequery(HttpServletRequest request){
        return new JsonResult(userService.pageQuery(getRequestForMap(request)));
    }


    public Map<String,Object> getRequestForMap(HttpServletRequest request){
        Map<String,Object> params = new HashMap<>();
        Map<String, String[]> values = request.getParameterMap();
        for(String key : values.keySet()){
            String[] vals = values.get(key);
            if(vals == null){
                continue;
            }
            if(vals.length == 1){
                params.put(key, vals[0]);
                continue;
            }
            params.put(key, vals);
        }
        return params;
    }
}
