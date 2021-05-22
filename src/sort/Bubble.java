package sort;

import static utils.ArrayUtils.*;

/**
 * Created by jiayanguo on 8/28/16.
 * O(n^2)
 */
public class Bubble {

    public static int[] bubbleSort(int[] nums){
        if (nums == null || nums.length ==0 || nums.length ==1) return nums;
        for (int i =0; i<nums.length; i ++){
            for (int j = nums.length-1; j>i; j--){
                if (nums[i] > nums [j]) {
                    swap(nums, i ,j);
                }
            }
        }
        return  nums;
    }

    public static void main(String[] args){
        int[] nums = randomIntArray(15, 100);
        nums = bubbleSort(nums);
        for (int i =0; i <nums.length; i++){
            System.out.println(nums[i]);
        }

        assertSortedArray(nums);
    }
}
