/**
 * Implementation of the binary search algorithm.
 * Input array may contain duplicate elements.
 * 
 * @author Zezhou Jing, University of Washington
 * @date August 25, 2016
 */
public class BinarySearch {
    // @param nums: a sorted integer array with possible duplicate elements
    // @param target: target element to search
    // @return: the first appearance of the element. Returns -1 if not found
    // an implementation of the binary search algorithm
    // note the input array may contain duplicates
    // it makes O(log n) comparisons using constant space
    public int binarySearch(int[] nums, int target) {
        // boundary cases
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // binary search algorithm
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            // to avoid overflow
            int mid = start + (end - start) / 2;
            // may assume the element found is the last index
            // of a series of duplicate elements
            if (nums[mid] == target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        // first check if the element is found
        // if so return the first index of its appearance
        if (nums[start] == target) {
            return start;
        }
        // not found, return -1
        return -1;
    }
}
