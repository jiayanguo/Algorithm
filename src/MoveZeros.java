/**
 * Created by jiayanguo on 9/6/16.
 */
public class MoveZeros {

    public static void main(String[] args){
        MoveZeros moveZeros = new MoveZeros();
        int[] nums = {0, 1, 0, 3, 12};
        moveZeros.move(nums);

        for (int i : nums){
            System.out.println(i+ " ");
        }
    }

    public void move (int[] nums){
        if (nums == null || nums.length == 0 || nums.length == 1){
            return;
        }

        int j = 0 ;

        for (int i =0; i < nums.length; i++ ){
            if(nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
    }

    private void swap (int[] nums, int i, int j){
        if (nums == null) return;
        if (i<0 || j< 0 || j >= nums.length || i>= nums.length) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
