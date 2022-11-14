package cn.tomato.springframework.beans;

/**
 * @author yangdh
 * @Descrition 类描述信息
 * @date 2022/4/13 22:33
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}