package sort;

/**
 * Created by jiayanguo on 8/28/16.
 */
public class Bubble {

    public int[] bubbleSort(int[] nums){
        if (nums == null || nums.length ==0 || nums.length ==1) return nums;
        for (int i =0; i<nums.length; i ++){
            for (int j = nums.length-1; j>i; j--){
                if( nums[j]<nums[j-1]) swap(nums, j, j-1);
            }
        }
        return  nums;
    }

    private void swap (int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        Bubble bubble = new Bubble();
        int[] nums = {1,3, 5,2, 9, 10, 7, 45, 6};
        nums = bubble.bubbleSort(nums);
        for (int i =0; i <nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
