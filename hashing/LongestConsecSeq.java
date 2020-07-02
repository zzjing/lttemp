import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecSeq {
    public int getLongestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int longStreak = 0;
        Set<Integer> numbers = new HashSet<>();
        // add all numbers to a set
        // for quick lookup and removal of duplicates
        for (int num : nums) {
            numbers.add(num);
        }
        for (int num : numbers) {
            // always start counting streak from
            // the smallest element of a subsequence
            if (!numbers.contains(num - 1)) {
                int curStart = num;
                int curStreak = 1;
                // start counting a streak
                while (numbers.contains(curStart + 1)) {
                    curStart++;
                    curStreak++;
                }
                // update the longest streak
                longStreak = Math.max(longStreak, curStreak);
            }
        }
        return longStreak;
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int curStreak = 1;
        int longStreak = 1;
        for (int i = 1; i < nums.length; i++) {
            // if elements are equal, streaks are unchanged
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    curStreak++;
                } else {
                    longStreak = Math.max(longStreak, curStreak);
                    curStreak = 1;
                }
            }
        }
        // fencepost condition
        return Math.max(curStreak, longStreak);
    }
}
