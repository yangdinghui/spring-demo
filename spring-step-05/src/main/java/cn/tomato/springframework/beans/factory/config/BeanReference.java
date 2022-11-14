package cn.tomato.springframework.beans.factory.config;

/**
 * @author yangdh
 * @Descrition 类描述信息
 * @date 2022/4/17 22:18
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
