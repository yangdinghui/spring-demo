package cn.tomato.springframework.beans.factory;

import cn.tomato.springframework.beans.BeansException;
import cn.tomato.springframework.beans.factory.config.BeanDefinition;

/**
 * @author yangdh
 * @Descrition 类描述信息
 * @date 2022/4/17 22:17
 */
public interface ConfigurableListableBeanFactory {
    /**
     * getBeanDefinition
     *
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
