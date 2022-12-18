package org.xubang.ioc.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/12/18 21:06
 * @Description
 */
public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        //获取指定bean的bean信息，剔除掉父类（Object）的影响：
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);

        /**
         * 1.Returns a sequential ordered stream whose elements are the specified values.   PropertyDescriptor[] getPropertyDescriptors(); 返回的结果作为Stream.of()的元素
         * 2.打印Person的每一个属性propertyDescriptor信息
         *
         */
        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    System.out.println(propertyDescriptor);
                });
    }
}