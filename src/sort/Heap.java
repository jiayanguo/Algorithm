package sort;

/**
 * Created by jiayanguo on 8/28/16.
 *
 * Max heap: parent[i] > A[i]
 */
public class Heap {

    public void maxHeapify(int[] nums, int i, int len){
        if (nums == null || len> nums.length || len == 0 || len == 1) return;
        int l = 2*i+1;
        int r = 2*i+2;
        int largest = i;

        if (l < len && nums[l] > nums[i]) {
            largest = l;
        }
        if (r < len && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != i){
            swap(nums, i, largest);
            maxHeapify(nums, largest, len);
        }

    }

    public void buildMaxHeap(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length==1) return;
        int mid = nums.length/2;

        for (int i= mid; i>=0; i --){
            maxHeapify(nums, i, nums.length);
        }
    }

    private void swap (int[] nums, int i, int j){
        if (i>=nums.length || j >= nums.length) return;
        int temp= nums[i];
        nums[i] = nums[j];
        nums[j]=temp;
    }

    public int[] heapSort(int[] nums){
        if (nums == null || nums.length == 0 || nums.length==1) return nums;
        buildMaxHeap(nums);

        for (int i = nums.length-1; i>0; i--){
            swap(nums,0, i);
            maxHeapify(nums, 0, i);
        }
        return nums;
    }


    public static void main (String[] args){
        Heap heap = new Heap();
        int[] nums = {1,3, 5,2, 9, 10, 7, 45, 6};
        heap.maxHeapify(nums, 0, nums.length);
        for (int i =0; i <nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        int[] nums1 = {1,3, 5,2, 9, 10, 7, 45, 6};
        heap.buildMaxHeap(nums1);
        for (int i =0; i <nums1.length; i++){
            System.out.print(nums1[i] + " ");
        }

        System.out.println();
        int[] nums2 = {1,3, 5,2, 9, 10, 7, 45, 6};
        heap.heapSort(nums2);
        for (int i =0; i <nums2.length; i++){
            System.out.print(nums2[i] + " ");
        }
    }


}
