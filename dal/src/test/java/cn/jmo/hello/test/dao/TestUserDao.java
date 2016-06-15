package cn.jmo.hello.test.dao;

import cn.jmo.hello.dao.UserDao;
import cn.jmo.hello.model.UserDO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUserDao extends BaseTest{

    @Autowired
    private UserDao userDao;

    private int insert(UserDO userDO){
        userDO.setUsername("wowjvogk");
        userDO.setPassword("rhsshciu");
        userDO.setGender("dbnnxqbc");
        userDO.setAge(60);
        userDO.setGmtRegist(new Date());
        return userDao.insert(userDO);
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
        UserDO userDOGet = userDao.getById(id);
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
        int r = userDao.update(userDO);
        Assert.assertTrue(r == 1);
    }

    @Test
    public void testDelete(){
        UserDO userDO = new UserDO();
        insert(userDO);
        long id = userDO.getId();
        int r = userDao.deleteById(id);
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
        List<UserDO> data = userDao.queryByParams(query);
        Assert.assertTrue(data != null);
    }

    @Test
    public void testPageQuery(){
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
        List<UserDO> data = userDao.queryByPage(query);
        Assert.assertTrue(data != null);
    }
}