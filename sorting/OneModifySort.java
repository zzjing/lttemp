
public class OneModifySort {
    public boolean checkOneModify(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        // two options when inversions occur: increase current or decrease prev
        // decrease nums[i - 1] s.t. nums[i - 1] = nums[i] if possible
        // this occurs when nums[i - 2] does not exist or nums[i - 2] < nums[i]
        // otherwise increase nums[i] s.t. nums[i] = nums[i - 1]
        int inversion = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < prev) {
                inversion++;
                if (inversion > 1) {
                    return false;
                }
                // increase nums[i]
                if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                    continue;
                }
            } // decrease nums[i - 1]
            prev = nums[i];
        }
        return true;
    }

    public boolean oneModifySort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int inversion = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                inversion++;
                if (inversion > 1) {
                    return false;
                }
                // increase nums[i]
                if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i - 1] = nums[i];
                }
            }
        }
        return true;
    }
}
