package cn.tomato.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yangdh
 * @Descrition 类描述信息
 * @date 2022/4/17 22:09
 */
public interface Resource {
    /**
     * getInputStream
     *
     * @return
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;
}
