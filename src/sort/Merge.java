package sort;

/**
 * Created by jiayanguo on 8/27/16.
 */
public class Merge {
    public int[] mergeSort(int[] nums){
        int mid = nums.length/2;
        if (mid == 0) return nums;
        int right[] = new int[nums.length-mid];
        int left[] = new int[mid];

        for (int i =0; i< mid; i ++){
            left[i]= nums[i];
        }
        for (int i = mid; i< nums.length; i++){
            right[i-mid] = nums [i];
        }

        right = mergeSort(right);
        left = mergeSort(left);

        int[] result = merge(left, right);
        return result;
    }

    private int[] merge (int[] nums1, int[] nums2){
        if (nums1.length == 0) return nums2;
        if (nums2.length == 0) return nums1;
        int[] result = new int[nums1.length+ nums2.length];
        int index = 0;
        int i=0;
        int j=0;
        while (index < result.length){
            if (i == nums1.length){
                result[index++]=nums2[j++];
                continue;
            }
            if (j == nums2.length){
                result[index++]=nums1[i++];
                continue;
            }
            if (nums1[i]<nums2[j]){
                result[index++]=nums1[i++];
            }else {
                result[index++]=nums2[j++];
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[] nums = {1,3, 5,2, 9, 10, 7, 45, 6};
        Merge merge = new Merge();
        nums = merge.mergeSort(nums);

        for (int num: nums){
            System.out.println(num + " ");
        }

    }
}
