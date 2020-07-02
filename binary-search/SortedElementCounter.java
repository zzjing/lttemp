
public class SortedElementCounter {
    public int searchCount(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int firstOccur = searchFirst(nums, target);
        int lastOccur = searchLast(nums, target);
        // returns -1 - 1 + 1 = -1 if not found
        return (lastOccur - firstOccur + 1);
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
        int last = 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                // continue search toward the right higher indices
                last = mid;
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return last;
    }

    public int linearCount(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }
}
