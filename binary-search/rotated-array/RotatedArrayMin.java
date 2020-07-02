/**
 * Find the smallest element in a sorted array
 * which may be rotated around a pivot element.
 * 
 * @author Zezhou Jing, University of Washington
 * @date August 28, 2016
 */
public class MinRotatedArray {
    public int getMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            //if the linear monotonically increasing in [start, end]
            if (nums[start] < nums[end]) {
                return nums[start];
            }
            int mid = start + (end - start) / 2;
            if (nums[mid] >= nums[start]) {
                start = mid + 1; // exclude nums[mid] since it is bigger than nums[start]
            } else {
                end = mid; // cannot exclude nums[mid] since it is smaller
            }
        }
        return nums[start];
    }

    public int findMin(int[] nums) {
        // @param nums: a sorted integer array which may be rotated around a pivot
        // @return: the minimum element of the array
        // binary search method; Time complexity O(log n), space O(1)
        // simple boundary cases
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;
        // already sorted
        if (nums[start] < nums[end]) {
            return nums[start];
        }
        // Note that nums[end] never moves past min element
        while (start <= end) {
            // nums[end] is at min
            if (end - start == 1) {
                return nums[end];
            }
            int mid = start + (end - start) / 2;
            // nums[mid] is still at rotated part
            if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                // nums[mid] is at sorted part
                end = mid;
            }
        }
        // otherwise nums[start] is at min
        return nums[start];
    }
}
