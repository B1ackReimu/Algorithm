public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        int data = 3;
        int search = search(arr, data);
        System.out.println(search);
    }

    static int search(int[] arr, int data) {
        int low = 0;
        int height = arr.length - 1;
        while (low <= height) {
            int mid = low + ((height - low) / 2);
            if (arr[mid] < data) {
                low = mid + 1;
            } else if (arr[mid] == data) {
                return mid;
            } else if (arr[mid] > data) {
                height = mid - 1;
            }
        }
        return -1;
    }

    // 二分查找法强依赖有序数组，数组缺陷：没有办法灵活插入和动态扩容
}
