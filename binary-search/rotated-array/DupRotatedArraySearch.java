
public class DupRotatedArraySearch {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // we know for sure right side is sorted or left side is unsorted
            if (nums[start] < nums[mid] || nums[mid] > nums[end]) {
               if (target >= nums[start] && target < nums[mid]) {
                   end = mid - 1;
               } else {
                   start = mid + 1;
               }
            // we know for sure left side is sorted or right side is unsorted
            } else if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            // If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
            // any of the two sides won't change the result but can help remove duplicate from
            // consideration, here we just use end-- but start++ works too
            } else {
                end--;
            }
        }
        return false;
    }
}
