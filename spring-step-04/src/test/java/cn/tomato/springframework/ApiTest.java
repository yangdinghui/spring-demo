package cn.tomato.springframework;

import cn.tomato.springframework.bean.UserDao;
import cn.tomato.springframework.bean.UserService;
import cn.tomato.springframework.beans.PropertyValue;
import cn.tomato.springframework.beans.PropertyValues;
import cn.tomato.springframework.beans.factory.config.BeanDefinition;
import cn.tomato.springframework.beans.factory.config.BeanReference;
import cn.tomato.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author yangdh
 * @Descrition 类描述信息
 * @date 2022/4/13 11:33
 */
public class ApiTest {
    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();


        PropertyValues propertyValues1 = new PropertyValues();
        propertyValues1.addPropertyValue(new PropertyValue("userService", new BeanReference("userService")));
        // 2. UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4. UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
