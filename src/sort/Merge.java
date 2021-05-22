package sort;

import static utils.ArrayUtils.*;

/**
 * Created by jiayanguo on 8/27/16.
 */
public class Merge {
    public static int[] mergeSort(int[] nums, int start, int end){
        if (start >= end) return nums;
        int mid = (start + end)/2;

        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

//        return mergeInPlace(nums, start, mid, end);
        return mergeWithNewArray(nums, start, mid, end);
    }

    /**
     * memory O(n)
     */
    private static int[] mergeInPlace (int[] nums, int start, int mid, int end){
        if ( start == end ) return nums;

        int i = mid;
        int j = end;
        while ( i >= start && j > i) {
            if (nums[i] >= nums[j]) {
                shift(nums, i, j);
                j--;
                i--;
            } else {
                j--;
            }
        }
        return nums;
    }

    private static int[] mergeWithNewArray (int[] nums, int start, int mid, int end){
        if ( start == end ) return nums;
        int i = start;
        int j = mid +1 ;
        int length = end +1 -start;
        int[] result = new int[length];
        int index = 0;
        while ( i <= mid || j <= end) {
            if (i > mid || j > end) {
                if (i > mid) {
                    result[index++] = nums[j++];
                } else if (j > end) {
                    result[index++] = nums[i++];
                }
            } else {
                if (nums[i] <= nums[j]) {
                    result[index++] = nums[i++];
                } else {
                    result[index++] = nums[j++];
                }
            }
        }

        index =0;
        for (int k = start; k <= end; k++) {
            nums[k]= result[index++];
        }

        return nums;
    }

    public static void main(String[] args){
        int[] nums = randomIntArray(15, 100);
        nums = mergeSort(nums, 0, nums.length -1);

        for (int num: nums){
            System.out.println(num + " ");
        }

        assertSortedArray(nums);
    }
}
