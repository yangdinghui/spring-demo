package cn.tomato.springframework.beans.factory.support;

import cn.tomato.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangdh
 * @Descrition 类描述信息
 * @date 2022/4/5 18:57
 */
public class DefaultSingletonBeanRegistry  implements SingletonBeanRegistry {
    private final Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
