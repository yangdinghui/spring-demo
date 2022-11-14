package cn.tomato.springframework.beans.factory.support;

import cn.tomato.springframework.test.beans.BeansException;
import cn.tomato.springframework.beans.factory.config.BeanDefinition;

/**
 * @author yangdh
 * @Descrition 类描述信息
 * @date 2022/4/5 18:55
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }
}
