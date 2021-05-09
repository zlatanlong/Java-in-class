package sort;

/**
 * @Author: zlatanlong
 * @Date: 2021/5/7 16:22
 */
public class SelectionSort {
    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) minIndex = j;
            }

            int tmp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = tmp;
        }
    }
}
