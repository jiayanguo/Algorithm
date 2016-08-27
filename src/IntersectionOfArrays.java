import utils.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiayanguo on 8/27/16.
 * Given two arrays, write a function to compute their intersection.


 */
public class IntersectionOfArrays {

    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        nums1 = Sort.sort(nums1);
        nums2 = Sort.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int index = nums1.length > nums2.length? nums1.length : nums2.length;
        int count =0;
        int i = 0;
        int j = 0;
        if (nums1.length==0 ) return nums1;
        if (nums2.length==0) return nums2;
        int max1= nums1[nums1.length-1];
        int max2= nums2[nums2.length-1];

        while (true){
            if(i >= nums1.length || j >= nums2.length) {break;}
            if (nums1[i]> max2 || nums2[j] >max1) break;
            if(nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
                continue;
            }
            if(nums1[i] > nums2[j]) {j++; continue;}
            if(nums1[i] < nums2[j]) i++;
        }

        int[] result = new int[list.size()];
        for (int l = 0; l< list.size(); l++){
            result[l]= list.get(l);
        }
        return result;
    }

    public static void main (String[] args){
        IntersectionOfArrays intersectionOfArray = new IntersectionOfArrays();
        int[] nums1 = {1,2,2,4};
        int[] nums2 = {2,2};
        int[] result = intersectionOfArray.intersection(nums1, nums2);

        for (int res : result){
            System.out.print(res + " ");
        }
    }
}
