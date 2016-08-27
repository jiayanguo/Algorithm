import java.util.Date;

/**
 * Created by jiayanguo on 8/27/16.
 *
 * Description:
 * Given an integer array nums with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 *Example
 Given nums = [1, 2, 4], target = 4

 The possible combination ways are:
 [1, 1, 1, 1]
 [1, 1, 2]
 [1, 2, 1]
 [2, 1, 1]
 [2, 2]
 [4]
 *
 */
public class BackPackV2 {
    /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    public int backPackVI(int[] nums, int target) {

        nums = sort(nums);

        int result =0;

       for(int num: nums) {
           if (num > target) break;
           if( num == target) result ++;
           if (num <target) {
               result += sub_backPack(nums, target, num);
           }
       }

        return result;
    }

    public int sub_backPack (int[] nums, int target, int sum){
        int result=0;
        for(int num: nums) {
            if (sum+num > target) break;
            if( sum+num  == target) result ++;
            if (sum+num  < target) {
                result += sub_backPack(nums, target, sum + num);
            }
        }
        return result;
    }

    public static void main (String[] args){
        BackPackV2 backPackV2 = new BackPackV2();
        int[] nums = {37,40,28,39,36,20,23,25,31,1,2,3,4};
        nums = backPackV2.sort(nums);
        for (int num : nums) {
            System.out.print(num + " " );
        }
        Long timestamp = new Date().getTime();
        System.out.println(backPackV2.backPackVI(nums,31));
        System.out.println("time conusme: "+ (new Date().getTime() - timestamp));
    }

    public int[] sort ( int [] nums) {
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
