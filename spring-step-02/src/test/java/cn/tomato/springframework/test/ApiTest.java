package cn.tomato.springframework.test;

import cn.tomato.springframework.beans.factory.config.BeanDefinition;
import cn.tomato.springframework.test.beans.UserService;
import cn.tomato.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author yangdh
 * @Descrition 类描述信息
 * @date 2022/4/5 11:13
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        System.out.println(userService);

        // 4.第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getSingleton("userService");
        userService_singleton.queryUserInfo();
        System.out.println(userService_singleton);
    }
}
