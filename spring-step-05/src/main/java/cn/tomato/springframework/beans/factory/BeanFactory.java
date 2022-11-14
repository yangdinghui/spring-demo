package cn.tomato.springframework.beans.factory;

import cn.tomato.springframework.beans.BeansException;

/**
 * @author yangdh
 * @Descrition 类描述信息
 * @date 2022/4/17 22:15
 */
public interface BeanFactory {

    /**
     * getBean
     *
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;

    /**
     * getBean
     *
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    Object getBean(String name, Object... args) throws BeansException;

    /**
     * getBean
     *
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
