
public class RangeSearch {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int firstOccur = searchFirst(nums, target);
        int lastOccur = searchLast(nums, target);
        return new int[]{firstOccur, lastOccur};
    }

    private int searchFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int first = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                // continue search toward the left lower indices
                first = mid;
                end = mid - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return first;
    }

    private int searchLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int last = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                // continue search toward the right higher indices
                last = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return last;
    }
    // alternative solution to the problem
    public int[] searchInterval(int[] nums, int target) {
        int[] range = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return range;
        }
        int start = 0;
        int end = nums.length - 1;
        // get the starting index by shinrking the range to the left
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = mid + 1;
            } else { // combines the case where nums[mid] == target
                end = mid; // target may be at mid or to its left!
            }
        }
        if (nums[start] != target) {
            return range;
        } else {
            range[0] = start;
        }
        // need to adjust only one boundary since the left index is found
        end = nums.length - 1;
        // get the ending index by shinrking the range to the right
        while (start < end) {
            int mid = 1 + start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        range[1] = end;
        return range;
    }
}
