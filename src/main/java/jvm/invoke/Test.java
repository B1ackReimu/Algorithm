package jvm.invoke;

import java.lang.reflect.Method;

public class Test {

    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class klass = Test.class;
        Method method = klass.getMethod("target", int.class);
        method.invoke(null, 0);
    }

}
