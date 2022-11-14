package cn.tomato.springframework.beans.factory.support;

import cn.tomato.springframework.beans.BeansException;
import cn.tomato.springframework.core.io.Resource;
import cn.tomato.springframework.core.io.ResourceLoader;

/**
 * @author yangdh
 * @Descrition 类描述信息
 * @date 2022/4/17 22:24
 */
public interface BeanDefinitionReader {

    /**
     * getRegistry
     *
     * @return
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * getResourceLoader
     *
     * @return
     */
    ResourceLoader getResourceLoader();

    /**
     * loadBeanDefinitions
     *
     * @param resource
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    /**
     * loadBeanDefinitions
     *
     * @param resources
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource... resources) throws BeansException;

    /**
     * loadBeanDefinitions
     *
     * @param location
     * @throws BeansException
     */
    void loadBeanDefinitions(String location) throws BeansException;
}
