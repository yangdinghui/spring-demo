package cn.tomato.springframework.beans.factory.config;

import cn.tomato.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author yangdh
 * @Descrition Configuration interface to be implemented by most bean factories. Provides
 * facilities to configure a bean factory, in addition to the bean factory
 * client methods in the {@link cn.tomato.springframework.beans.factory.BeanFactory}
 * interface.
 * @date 2022/4/17 22:20
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

}
