package sort;

/**
 * @Author: zlatanlong
 * @Date: 2021/5/7 16:28
 */
public class BubbleSort {

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean sorted = true;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if(nums[j]>nums[j+1]) {
                    int tmp = nums[j];
                     nums[j] = nums[j+1];
                     nums[j+1] = tmp;
                     sorted = false;
                }
            }
            if(sorted) break;
        }
    }
}
