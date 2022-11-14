package cn.tomato.springframework.beans;

/**
 * @author yangdh
 * @Descrition 类描述信息
 * @date 2022/4/13 22:34
 */
public class PropertyValue {
    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
