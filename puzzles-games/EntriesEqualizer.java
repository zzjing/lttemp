
public class EntriesEqualizer {
    public int minMoves(int[] nums) {
        // sum(array) - n * minimum
        if (nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        for (int n : nums) {
            min = Math.min(min, n);
        }
        int steps = 0;
        for (int n : nums) {
            steps += n - min;
        }
        return steps;
    }
}
