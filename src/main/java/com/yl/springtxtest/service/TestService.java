package com.yl.springtxtest.service;

import com.yl.springtxtest.component.SpringContextComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @author Liang.Yang5
 * @date 2018/9/12 13:10
 */
@Service
@Lazy
public class TestService {
    @Autowired
    private UserService userService;


    public void update() {
        for (int i = 1; i <= 10; i++) {
            try {
                SpringContextComponent.getBean(TestService.class).update(i);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update(int i) {
        try {
            String sql1 = "insert into user (user_name,password) values ('" + i + "','" + i + "')";
            String sql2 = "insert into user1 (user_name,password) values ('" + i + "','" + i + "')";
            userService.update(sql1);
            userService.update(sql2);
            if (i == 5) {
                int a = 2;
                String num = "0";
                int temp = a / Integer.valueOf(num);
                System.out.println(temp);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
}