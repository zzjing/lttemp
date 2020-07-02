
public class MissingNmber {
    public int getMissingNumber(int[] nums) {
        int lastNum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            lastNum ^= i;
            lastNum ^= nums[i];
        }
        return lastNum;
    }

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int wholeSum = (0 + nums.length) * (nums.length + 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            wholeSum -= nums[i];
        }
        return wholeSum;
    }
}
