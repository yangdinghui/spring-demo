package cn.tomato.springframework.beans.factory;

import cn.tomato.springframework.beans.BeansException;

import java.util.Map;

/**
 * @author yangdh
 * @Descrition 类描述信息
 * @date 2022/4/17 22:14
 */
public interface ListableBeanFactory extends BeanFactory {
    /**
     * 按照类型返回 Bean 实例
     *
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * Return the names of all beans defined in this registry.
     *
     * @return 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();
}
