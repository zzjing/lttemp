import java.util.Arrays;

public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int smallTriplet = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    // k can be any index whenever j < k' <= k
                    smallTriplet += (k - j);
                    j++;
                } else {
                    k--;
                }
            }
        }
        return smallTriplet;
    }
}
