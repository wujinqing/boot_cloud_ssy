package com.wujinqing.boot.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz = MyTest2.class;

        Method method = clazz.getDeclaredMethod("main", String[].class);

        // 调用静态方法，obj传null就行
        method.invoke(null, new Object[]{null});
    }
}
