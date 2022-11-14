package cn.tomato.springframework.util;

/**
 * @author yangdh
 * @Descrition 类描述信息
 * @date 2022/4/17 22:07
 */
public class ClassUtils {

    /**
     * getDefaultClassLoader
     *
     * @return
     */
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {
            // Cannot access thread context ClassLoader - falling back to system class loader...
        }
        if (cl == null) {
            // No thread context class loader -> use class loader of this class.
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }
}
