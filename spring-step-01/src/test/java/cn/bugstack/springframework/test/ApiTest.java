package cn.bugstack.springframework.test;

import cn.bugstack.springframework.BeanDefinition;
import cn.bugstack.springframework.BeanFactory;
import cn.bugstack.springframework.test.bean.UserService;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

    @Test
    public void test1() {
        List<String> listAll = Lists.newArrayList();
        List<String> list = Lists.newArrayList();
        listAll.addAll(list);
        listAll.add("Ssss");
        System.out.println(listAll.size());
        listAll.forEach(System.out::println);
    }
    @Test
    public void test2() {
        List<Date> list = new ArrayList<>();
        list.add(new Date());
        System.out.println(JsonUtils.toJson(list));
        System.out.println(JSONUtil.toJsonStr(list));
    }
}

class JsonUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    public static String toString(Object obj){
        return toJson(obj);
    }

    public static String toJson(Object obj){
        try{
            StringWriter writer = new StringWriter();
            mapper.writeValue(writer, obj);
            return writer.toString();
        }catch(Exception e){
            throw new RuntimeException("序列化对象【"+obj+"】时出错", e);
        }
    }

    public static <T> T toBean(Class<T> entityClass, String jsonString){
        try {
            return mapper.readValue(jsonString, entityClass);
        } catch (Exception e) {
            throw new RuntimeException("JSON【"+jsonString+"】转对象时出错", e);
        }
    }

    /**
     * 用于对象通过其他工具已转为JSON的字符形式，这里不需要再加上引号
     * @param obj
     * @param isObject
     */
    public static String getJsonSuccess(String obj, boolean isObject){
        String jsonString = null;
        if(obj == null){
            jsonString = "{\"success\":true}";
        }else{
            jsonString = "{\"success\":true,\"data\":"+obj+"}";
        }
        return jsonString;
    }

    public static String getJsonSuccess(Object obj){
        return getJsonSuccess(obj, null);
    }

    public static String getJsonSuccess(Object obj, String message) {
        if(obj == null){
            return "{\"success\":true,\"message\":\""+message+"\"}";
        }else{
            try{
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("success", true);
                return "{\"success\":true,"+toString(obj)+",\"message\":\""+message+"\"}";
            }catch(Exception e){
                throw new RuntimeException("序列化对象【"+obj+"】时出错", e);
            }
        }
    }

    public static String getJsonError(Object obj){
        return getJsonError(obj, null);
    }

    public static String getJsonError(Object obj, String message) {
        if(obj == null){
            return "{\"success\":false,\"message\":\""+message+"\"}";
        }else{
            try{
                obj = parseIfException(obj);
                return "{\"success\":false,\"data\":"+toString(obj)+",\"message\":\""+message+"\"}";
            }catch(Exception e){
                throw new RuntimeException("序列化对象【"+obj+"】时出错", e);
            }
        }
    }

    public static Object parseIfException(Object obj){
        if(obj instanceof Exception){
            return getErrorMessage((Exception) obj, null);
        }
        return obj;
    }

    public static String getErrorMessage(Exception e, String defaultMessage){
        return defaultMessage != null ? defaultMessage : null;
    }

    public static ObjectMapper getMapper() {
        return mapper;
    }
}
