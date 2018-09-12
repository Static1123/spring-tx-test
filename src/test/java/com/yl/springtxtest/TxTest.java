package com.yl.springtxtest;

import com.yl.springtxtest.service.TestService;
import com.yl.springtxtest.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Liang.Yang5
 * @date 2018/9/12 13:12
 */
public class TxTest extends SpringTxTestApplicationTests {
    @Autowired
    private UserService userService;

    @Autowired
    private TestService testService;

    @Test
    public void testUpdateUser() {
        String sql = "update user set password = '444555' where user_name = 'tom'";
        int i = userService.update(sql);
        System.out.println(i);

        sql = "update user1 set password = '111111' where user_name = 'tom'";
        i = userService.update(sql);
        System.out.println(i);
    }

    @Test
    public void testTx() {
        testService.update();
    }
}