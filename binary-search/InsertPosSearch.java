/**
 * Search an element in a sorted array.
 * If not found, give the index in the array to be inserted.
 * 
 * @author Zezhou Jing, University of Washington
 * @date August 26, 2016
 */
public class InsertPosSearch {
    // @param nums: a sorted integer array without duplicates
    // @param target: an integer to insert into the array
    // @return: the index to be inserted while maintaining sorted order
    // if found, return the index; if not return the insert position
    // binary search method; Time complexity O(log n), space O(1)
    public int searchInsert(int[] nums, int target) {
        // simple boundary cases
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // begin binary search 
        int start = 0;
        int end = nums.length - 1;
        // instead of (start <= end)
        // due to insert position
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        // first position >= target to insert while maintaining sorted array
        if (nums[start] >= target) { // take the place of start
            return start;
        } else if (nums[end] >= target) { // take the place of end (note >= relationship)
            return end;
        } else {
            return end + 1; // after the end entry
        }
    }
}
