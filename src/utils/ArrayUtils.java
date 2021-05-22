package utils;

import java.util.Random;

public class ArrayUtils {
    public static void swap( int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void shift(int[] nums, int i, int pos) {
        int index = i;
        while (index < pos) {
            swap(nums, index, index + 1);
            index ++;
        }
    }

    public static int[] randomIntArray(int length, int range) {
        int[] nums = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i ++) {
            nums[i] = random.nextInt(range);
        }
        return nums;
    }

    public static void assertSortedArray(int[] nums) {
        for(int i = 0; i < nums.length -1 ; i ++) {
            if (nums[i] > nums[i+1]) {
                throw new RuntimeException("Array is not sorted!");
            }
        }
    }
}
