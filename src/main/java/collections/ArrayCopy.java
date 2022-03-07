package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ArrayCopy {

    static Object[] objects2 = {};

    public static void main(String[] args) {
        Object[] objects = new Object[]{new Object(),new Object()};
        Object[] objects1 = new Object[10];
        System.arraycopy(objects,0,objects1,0,2);
        System.out.println(Arrays.toString(objects));
        System.out.println(Arrays.toString(objects1));
        System.out.println(objects2.length);
        ArrayList<AtomicInteger> arrayList = new ArrayList<AtomicInteger>(){{
            add(new AtomicInteger(1));
            add(new AtomicInteger(2));
            add(new AtomicInteger(3));
        }};
        ArrayList<AtomicInteger> arrayListCopy = (ArrayList<AtomicInteger>) arrayList.clone();
        arrayListCopy.add(0,new AtomicInteger(4));
        arrayListCopy.get(1).incrementAndGet();
        System.out.println(arrayList);
        System.out.println(arrayListCopy);

    }

}
