package com.windsoft.demo8.orm;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface TableAnnotation {
    /**
     * 用于标注类对应的表格名称
     * @return
     */
    String value();
}
