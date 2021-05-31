package sort;

import static utils.ArrayUtils.*;
/**
 * Created by jiayanguo on 8/28/16.
 */
public class Quick {

    private int partition (int[] nums, int start, int end){
        if (nums == null || nums.length == 0 || nums.length==1) return start;
        if (start>=end) return start;
        if (start<0 || start>=nums.length) return start;
        if (end<0 || end>=nums.length) return start;
        int i =start;
        int num = nums[start];
        for (int j= i +1; j<= end; j++){
            if (nums[j]<num) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, start, i);
        return i;
    }

    private void  quickSortHelper(int[] nums, int i, int j){
        if (nums == null || nums.length == 0 || nums.length==1) return;
        if (i< 0 || i>= nums.length) return;
        if (j< 0 || j>= nums.length) return;
        if (i>=j) return;

        int r = partition(nums, i, j);
        quickSortHelper(nums, r + 1, j);
        quickSortHelper(nums, i, r - 1);
    }

    public int[] quickSort(int[] nums){
        if (nums == null || nums.length == 0 || nums.length==1) return nums;

        quickSortHelper(nums, 0, nums.length-1);
        return nums;
    }

    public static void main (String[] args) {
        Quick quick = new Quick();
        int[] nums = randomIntArray(15, 100);
        quick.quickSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        assertSortedArray(nums);
    }
}
