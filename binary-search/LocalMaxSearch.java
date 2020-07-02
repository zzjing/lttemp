/**
 * Find a local maximum in a unsorted array.
 * i.e. A local maximum > both left and right neighbors.
 * 
 * @author Zezhou Jing, University of Washington
 * @date August 25, 2016
 */
public class LocalMaxSearch {
    // extreme value theorem
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int rightMid = mid + 1;
            if (nums[mid] < nums[rightMid]) {
                start = rightMid;
            } else {
                end = mid;
            }
        }
        return start;
    }

    // @param nums: an integer array with at least one local maximum
    // @return: a local maximum of the array
    // (alternate) binary search method; Time O(log n), space O(1)
    public int findLocalMax (int[] nums) {
        // check boundary cases
        if (nums == null || nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return 0;
        }
        // begin binary search algorithm
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // if nums[mid] is not a local max and less than its right neighbor
            // there exists a local maximum on the right interval
            if (nums[mid] < nums[mid + 1]) {
                start = mid;
                // if nums[mid] is not a local max and less than its left neighbor
                // there exists a local maximum on the left interval
            } else if (nums[mid] < nums[mid - 1]) {
                end = mid;
            } else {
                start = mid;
                // end = mid; also works, it does not matter
            }
        }
        // check local maximum
        if (nums[start] < nums[end]) {
            return end;
        } else {
            return start;
        }
    }
}
