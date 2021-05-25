import java.util.Arrays;
import java.util.Random;

public class SortAlgorithm {

    static int[] ints = new int[100];

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < ints.length; i++) {
            int a = random.nextInt(100000);
            ints[i] = a;
        }
        bubble();
        System.out.println(Arrays.toString(ints));
    }

    static void bubble() {
        int length = ints.length;
        for (int i = 0; i < length; i++) {
            for (int j = length-1; j > 0; j--) {
                int tmp;
                if (ints[j-1]<=ints[j]){
                    tmp=ints[j];
                    ints[j]=ints[j-1];
                    ints[j-1]=tmp;
                }
            }
        }
    }

}
