package jvm.invoke;

import java.lang.reflect.Method;

public class TestV4 {

    // -Djava.lang.Integer.IntegerCache.high=128
// -Dsun.reflect.noInflation=true
    public static void target(int i) {
        // 空方法
    }

    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("jvm.invoke.TestV4");
        Method method = klass.getMethod("target", int.class);
        method.setAccessible(true);  // 关闭权限检查

        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }

            method.invoke(null, 128);
        }
    }


}
