package cn.jmo.hello.test.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by qiangzi on 16/6/8.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/jmo_biz_service.xml","classpath*:spring/dal.xml"})
@TransactionConfiguration(transactionManager = "jmoTransactionManager")
public class BaseTest extends AbstractTransactionalJUnit4SpringContextTests{





}
