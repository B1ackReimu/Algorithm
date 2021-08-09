import java.util.Arrays;
import java.util.Random;

public class BubbleAlgorithm {

    static int[] ints = new int[20];

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < ints.length; i++) {
            int a = random.nextInt(1000);
            ints[i] = a;
        }
        bubble(true);
        System.out.println(Arrays.toString(ints));
        bubble(false);
        System.out.println(Arrays.toString(ints));
    }

    static void bubble(boolean reverse) {
        int length = ints.length;
        for (int i = 0; i < length; i++) {
            boolean out = false;

            int tmp;
            if (reverse) {
                for (int j = length - 1; j > 0; j--) {
                    if (ints[j - 1] < ints[j]) {
                        out = true;
                        tmp = ints[j];
                        ints[j] = ints[j - 1];
                        ints[j - 1] = tmp;
                    }
                }
            } else {
                for (int j = 0; j < length - 1; j++) {
                    if (ints[j] > ints[j + 1]) {
                        out = true;
                        tmp = ints[j];
                        ints[j] = ints[j + 1];
                        ints[j + 1] = tmp;
                    }
                }
            }
            if (!out) {
                break;
            }
            System.out.println(i);
        }
    }

}
