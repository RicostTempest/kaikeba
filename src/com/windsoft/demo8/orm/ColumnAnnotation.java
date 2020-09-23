package com.windsoft.demo8.orm;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ColumnAnnotation {
    /**
     * 描述列名
     * @return
     */
    String column();

    /**
     * 描述类型
     * @return
     */
    String type();

    /**
     * 描述数据长度
     * @return
     */
    String length();
}
