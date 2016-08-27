package utils;

/**
 * Created by jiayanguo on 8/27/16.
 */
public class Sort {

    public static int[] sort ( int [] nums) {
        for (int i=0; i<nums.length ; i ++) {
            for (int j =i + 1; j< nums.length; j++){
                if ( nums[i] > nums[j]) {
                    int min = nums[j];
                    nums[j] = nums[i];
                    nums[i]= min;
                }

            }
        }

        return nums;
    }

}
