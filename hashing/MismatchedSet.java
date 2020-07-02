
public class MismatchedSet {
    // Hashing solution; Time complexity O(n), space O(1)
    public int[] findErrorNums(int[] nums) {
        int[] errors = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) {
               errors[0]  = Math.abs(nums[i]);
            } else {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                errors[1] = i + 1;
            }
        }
        return errors;
    }
    // alternative solution using extra space O(n)
    /*
    public int[] findErrorNums(int[] nums) {
        int[] counter = new int[nums.length + 1];
        int missing = -1;
        int twice = - 1;
        for (int i = 0; i < nums.length; i++) {
            counter[nums[i]]++;
            if (counter[nums[i]] == 2) {
                twice = nums[i];
            }
        }
        for (int i = 1; i < counter.length; i++) {
            if (counter[i] == 0) {
                missing = i;
            }
        }
        return new int[]{twice, missing};
    }
    */
}
