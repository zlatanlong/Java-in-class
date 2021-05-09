package sort;

import java.util.Arrays;

/**
 * @Author: zlatanlong
 * @Date: 2021/5/7 20:23
 */
public class Test {

    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int j = i;
            while (j>0 && nums[j-1] > cur){
                nums[j] =  nums[j-1];
                j--;
            }
            nums[j] = cur;
        }
    }

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean sorted = true;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }

    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) minIndex = j;
            }
            swap(nums, i, minIndex);
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 1, 6, 7, 11, 221, 0, -1, 22, 33, 4554};
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int[] arr3 = Arrays.copyOf(arr, arr.length);

        Test.insertionSort(arr);
        Test.bubbleSort(arr2);
        Test.selectionSort(arr3);
        Arrays.stream(arr).forEach(a -> System.out.print(a + ", "));
        System.out.println();
        Arrays.stream(arr2).forEach(a -> System.out.print(a + ", "));
        System.out.println();
        Arrays.stream(arr3).forEach(a -> System.out.print(a + ", "));
        System.out.println();
    }
}
