import sort.Quick;

import java.util.Arrays;
import java.util.Random;

import static utils.ArrayUtils.randomIntArray;

public class BinarySearch {

    /**
     * Find the first value more than a given value v in the array and return the index;
     */
    public static int search (int v, int[] arr) {
        if (arr == null) {
            return 0;
        }
        int left =0;
        int right = arr.length - 1;
        int result = arr.length +1;
        while (left <= right && right < arr.length) {
            int mid = (left + right)/2;
            if (arr[mid] >= v ) {
                if (mid +1 < result) {
                    result = mid + 1;
                }
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return result;
    }

    /**
     * recursive
     * @param v
     * @param arr
     * @return
     */
    public static int search2 (int v, int[] arr) {
        if (arr == null) {
            return 0;
        }
        int left =0;
        int right = arr.length - 1;
        int result = arr.length + 1;
        int mid = (left + right )/2;
        int candiate ;
        if (arr[mid] >= v ) {
            if (mid +1 < result) {
                result = mid + 1;
            }
            candiate = findMin(left, mid -1, v, arr, result);
        } else {
            candiate = findMin(mid +1 , right, v, arr, result);
        }

        if ( candiate < result) {
            result = candiate;
        }

        return result;
    }

    private static int findMin(int start, int end, int v, int[] arr, int curr) {
        if (start > end || end >= arr.length) return curr;
        int mid = (start + end )/2;
        int candidate ;
        if (arr[mid] >= v ) {
            if (mid +1 < curr) {
                curr = mid + 1;
            }
            candidate = findMin(start, mid -1, v, arr, curr);
        } else {
            candidate = findMin(mid +1 , end, v, arr, curr);
        }

        if ( candidate < curr) {
            curr = candidate;
        }

        return curr;
    }

    public static void main(String[] args) {
        int[] nums = randomIntArray(15, 100);
        Arrays.sort(nums);
        Arrays.stream(nums).sequential().forEach(ele -> System.out.print(ele + " "));
        Random random = new Random();
        int value = random.nextInt(100);
        System.out.println("given value: " + value);
        int result = search(value, nums);
        System.out.println(result);
        System.out.println(search2(value, nums));
    }
}
