package cn.tomato.springframework.beans.factory.config;

/**
 * @author yangdh
 * @Descrition 类描述信息
 * @date 2022/4/17 22:19
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
