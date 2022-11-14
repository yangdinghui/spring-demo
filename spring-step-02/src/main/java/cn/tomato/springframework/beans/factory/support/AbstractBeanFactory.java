package cn.tomato.springframework.beans.factory.support;

import cn.tomato.springframework.test.beans.BeansException;
import cn.tomato.springframework.test.beans.factory.BeanFactory;
import cn.tomato.springframework.beans.factory.config.BeanDefinition;

/**
 * @author yangdh
 * @Descrition 类描述信息
 * @date 2022/4/5 18:56
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
