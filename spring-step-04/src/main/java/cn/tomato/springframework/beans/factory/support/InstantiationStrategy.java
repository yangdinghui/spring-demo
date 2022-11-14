package cn.tomato.springframework.beans.factory.support;

import cn.tomato.springframework.beans.BeansException;
import cn.tomato.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author yangdh
 * @Descrition Bean 实例化策略
 * @date 2022/4/13 22:46
 */
public interface InstantiationStrategy {

    /**
     * instantiate
     *
     * @param beanDefinition
     * @param beanName
     * @param ctor
     * @param args
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
