package cn.tomato.springframework.core.io;

/**
 * @author yangdh
 * @Descrition 类描述信息
 * @date 2022/4/17 22:09
 */
public interface ResourceLoader {
    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * getResource
     *
     * @param location
     * @return
     */
    Resource getResource(String location);

}
