package cn.jmo.hello.test.service;

import cn.jmo.hello.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by qiangzi on 16/6/13.
 */

public class TestAffair extends BaseTest{


    @Autowired
    private UserService userService;

    @Test
    public void test01(){
        userService.add();
    }
}
