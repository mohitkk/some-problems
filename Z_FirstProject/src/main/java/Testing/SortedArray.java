package Testing;

public class SortedArray {

    public static void main(final String[] args) {
        final int[] arr = { 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 1, 1, 2, 2, 3, 4 };
        System.out.println(find1(arr));
        System.out.println(find2(arr));
    }

    public static int find1(final int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                min = arr[i + 1];
                break;
            }
        }
        return min;
    }

    public static int find2(final int[] arr) {
        return find2(arr, 0, arr.length - 1);
    }

    public static int find2(final int[] arr, final int left, final int right) {
        // System.out.println(arr[left] + "---------" + arr[right]);
        final int center = (left + right) / 2;
        if (center == left) {
            return Math.min(arr[left], arr[right]);
        }
        if (arr[center] > arr[right]) {
            return find2(arr, center, right);
        } else {
            return find2(arr, left, center);
        }
    }
}
