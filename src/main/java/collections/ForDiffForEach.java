package collections;

public class ForDiffForEach {

    public static void main(String[] args) {
        int[] ints = new int[]{0,1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < ints.length; i++) {
            System.out.println(i);
        }

        for (int anInt : ints) {
            System.out.println(anInt);
        }

        System.out.println(10>>1);

        Object[] objects = new Object[10];
        Class<? extends Object[]> aClass = objects.getClass();
        System.out.println((Object) aClass == (Object) Object[].class);

        Integer[] integers = new Integer[10];
        Class<? extends Integer[]> aClass1 = integers.getClass();
        System.out.println((Object) aClass1 == (Object) Object[].class);

        System.out.println(integers.getClass().getComponentType());
    }

}
