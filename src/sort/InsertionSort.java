package sort;

/**
 * @Author: zlatanlong
 * @Date: 2021/5/7 17:14
 */
public class InsertionSort {

    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int insertIndex = i;
            int cur = nums[i]; // 此次要移动的值
            while (insertIndex > 0 && nums[insertIndex - 1] > cur) {
                nums[insertIndex] = nums[insertIndex - 1];
                insertIndex--;
            }
            nums[insertIndex] = cur;
        }
    }

}
