
public class LengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int longest = 1;
        int currentStreak = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                currentStreak++;
            } else {
                currentStreak = 1;
            }
            longest = Math.max(longest, currentStreak);
        }
        return longest;
    }
}
