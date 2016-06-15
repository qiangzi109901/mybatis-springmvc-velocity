package cn.jmo.hello.test.service;


import cn.jmo.hello.helper.PageResult;
import cn.jmo.hello.model.UserDO;
import cn.jmo.hello.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class TestUserService extends BaseTest{

    @Autowired
    private UserService userService;

    private int insert(UserDO userDO){
        userDO.setUsername("wowjvogk");
        userDO.setPassword("rhsshciu");
        userDO.setGender("dbnnxqbc");
        userDO.setAge(60);
        userDO.setGmtRegist(new Date());
        return userService.insert(userDO);
    }

    @Test
    public void testInsert(){
        int r = insert(new UserDO());
        Assert.assertTrue(r == 1);
    }

    @Test
    public void testGetById(){
        UserDO userDO = new UserDO();
        insert(userDO);
        long id = userDO.getId();
        UserDO userDOGet = userService.getById(id);
        System.out.println(userDOGet);
        Assert.assertTrue(userDOGet != null && userDOGet.getId() == id);
    }

    @Test
    public void testUpdate(){
        UserDO userDO = new UserDO();
        insert(userDO);
        userDO.setUsername("fqtarhyi");
        userDO.setPassword("toycdmgb");
        userDO.setGender("vcjnxufu");
        userDO.setAge(49);
        userDO.setGmtRegist(new Date());
        int r = userService.update(userDO);
        Assert.assertTrue(r == 1);
    }

    @Test
    public void testDelete(){
        UserDO userDO = new UserDO();
        insert(userDO);
        long id = userDO.getId();
        int r = userService.deleteById(id);
        Assert.assertTrue(r == 1);
    }

    @Test
    public void testQuery(){
        UserDO userDO = new UserDO();
        for(int i=0;i<40;i++){
            insert(userDO);
        }
        Map<String,Object> query = new HashMap();
        //下面的参数自行修改、完善
        query.put("id", 38);
        query.put("username", "aupgjpma");
        query.put("password", "bfjuhhrm");
        query.put("gender", "dzdidxkl");
        query.put("age", 40);
        query.put("gmtRegist", new Date());
        List<UserDO> data = userService.queryByParams(query);
        Assert.assertTrue(data != null);
    }

    @Test
    public void testQueryPage(){
        UserDO userDO = new UserDO();
        for(int i=0;i<80;i++){
            insert(userDO);
        }
        Map<String,Object> query = new HashMap();
        //下面的参数自行修改、完善
        query.put("id", 25);
        query.put("username", "ckpnbjwu");
        query.put("password", "nqhpkdod");
        query.put("gender", "lmbhxzof");
        query.put("age", 1);
        query.put("gmtRegist", new Date());
        query.put("offset", 1);
        query.put("pageSize", 10);
        List<UserDO> data = userService.queryByPage(query);
        Assert.assertTrue(data != null);
    }

    @Test
    public void testPageQuery(){
        Map<String,Object> query = new HashMap();
        //下面的参数自行修改、完善
        query.put("username", "wowjvogk");
        query.put("offset", 1);
        query.put("pageSize", 10);
        PageResult<UserDO> pageResult = userService.pageQuery(query);
        System.out.println(pageResult);
        Assert.assertTrue(pageResult.getTotal() >= 0);
    }

}