package cn.tomato.springframework.beans.factory.config;

/**
 * @author yangdh
 * @Descrition 类描述信息
 * @date 2022/4/5 11:11
 */
public class BeanDefinition {
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
