package cn.tomato.springframework.test.beans.factory;

import cn.tomato.springframework.test.beans.BeansException;

/**
 * @author yangdh
 * @Descrition 类描述信息
 * @date 2022/4/5 11:11
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
}
