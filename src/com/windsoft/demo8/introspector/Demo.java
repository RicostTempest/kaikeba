package com.windsoft.demo8.introspector;

import java.beans.*;
import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) throws IntrospectionException {
        Class c = Express.class;
        BeanInfo beanInfo = Introspector.getBeanInfo(c);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd: pds){
            Method get = pd.getReadMethod();
            Method set = pd.getWriteMethod();

        }
    }
}
