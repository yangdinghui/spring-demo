package cn.tomato.springframework.beans.factory.config;

/**
 * @author yangdh
 * @Descrition 单例注册表
 * @date 2022/4/13 22:44
 */
public interface SingletonBeanRegistry {
    /**
     * getSingleton
     *
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);
}
