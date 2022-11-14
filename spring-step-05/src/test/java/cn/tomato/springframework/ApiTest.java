package cn.tomato.springframework;

import cn.hutool.core.io.IoUtil;
import cn.tomato.springframework.bean.UserDao;
import cn.tomato.springframework.bean.UserService;
import cn.tomato.springframework.beans.PropertyValue;
import cn.tomato.springframework.beans.PropertyValues;
import cn.tomato.springframework.beans.factory.config.BeanDefinition;
import cn.tomato.springframework.beans.factory.config.BeanReference;
import cn.tomato.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.tomato.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.tomato.springframework.core.io.DefaultResourceLoader;
import cn.tomato.springframework.core.io.Resource;
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

    @Test
    public void test_url() throws IOException {
//        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/important.properties");
//        Resource resource = resourceLoader.getResource("https://docs.qq.com/sheet/DZkFGa01saXZjRXJ1?tab=BB08J2");
//        Resource resource = resourceLoader.getResource("https://github.com/yangdinghui/ChineseBQB/blob/master/001Funny_%E6%BB%91%E7%A8%BD%E5%A4%A7%E4%BD%AC%F0%9F%98%8FBQB/Funny00001.gif");
        Resource resource = resourceLoader.getResource("https://github.com/yangdinghui/Code-Guide/blob/master/redis%E4%B8%AD%E6%96%87%E6%B3%A8%E9%87%8A%E7%89%88.conf");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);

    }
}
