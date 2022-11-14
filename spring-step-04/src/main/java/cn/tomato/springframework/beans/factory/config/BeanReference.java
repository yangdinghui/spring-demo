package cn.tomato.springframework.beans.factory.config;

/**
 * @author yangdh
 * @Descrition Bean 的引用
 * @date 2022/4/13 22:44
 */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}
