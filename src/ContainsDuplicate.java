public class ContainsDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k==0) return false;
        if (nums.length == 0 || nums.length == 1) return false;
        
        k = k > nums.length ? nums.length : k;
        
        for ( int i = 0; i < nums.length-1; i++){
            for (int j = i+1; j-i <=k && j < nums.length; j++) {
                long diff = (long)nums[i]- nums[j];
                if (diff <= t && diff >= -t) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums =  {2147483647,-2147483647};
        System.out.println(new ContainsDuplicate().containsNearbyAlmostDuplicate(nums, 1, 2147483647));
    }
}