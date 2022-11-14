package cn.tomato.springframework.test;

import cn.hutool.core.io.IoUtil;
import cn.tomato.springframework.beans.PropertyValue;
import cn.tomato.springframework.beans.PropertyValues;
import cn.tomato.springframework.beans.factory.config.BeanDefinition;
import cn.tomato.springframework.beans.factory.config.BeanReference;
import cn.tomato.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.tomato.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.tomato.springframework.core.io.DefaultResourceLoader;
import cn.tomato.springframework.core.io.Resource;
import cn.tomato.springframework.test.bean.UserDao;
import cn.tomato.springframework.test.bean.UserService;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yangdh
 * @Descrition 类描述信息
 * @date 2022/4/17 22:02
 */
public class ApiTest {
    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

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
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

}
