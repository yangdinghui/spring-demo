package cn.tomato.springframework.beans.factory.support;

import cn.tomato.springframework.beans.factory.config.BeanDefinition;

/**
 * @author yangdh
 * @Descrition 类描述信息
 * @date 2022/4/5 18:59
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注册 BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
