package sort;

/**
 * Created by jiayanguo on 8/27/16.
 */
public class Insert {

    public int[] insertSort (int [] nums) {

        for (int i = 1; i < nums.length; i++){
            int num = nums[i];
            int j = i-1;
            while ( j >= 0 && nums[j] > num){
                nums[j+1] = nums [j];
                j--;
            }
            nums[j+1] = num;
        }

        return nums;
    }

    public static void main (String[] args){
        int[] nums = {1,3, 5,2, 9, 10, 7, 45, 6};
        nums = new Insert().insertSort(nums);
        for (int i =0; i <nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
