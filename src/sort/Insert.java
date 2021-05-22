package sort;


import static utils.ArrayUtils.*;

/**
 * Created by jiayanguo on 8/27/16.
 * O(n^2)
 */
public class Insert {

    public int[] insertSort (int [] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }

        for (int i = 1; i < nums.length ; i ++) {
            for (int j = i - 1; j >= 0; j --) {
                if (nums[j] > nums[j +1 ]) {
                    swap(nums, j, j+1);
                }
            }
        }
        return nums;
    }

    public static void main (String[] args){
        int[] nums = randomIntArray(15, 100);
        nums = new Insert().insertSort(nums);
        for (int i =0; i <nums.length; i++){
            System.out.println(nums[i]);
        }
        assertSortedArray(nums);
    }
}
