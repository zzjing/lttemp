
public class ZeroesRightShift {
    public void moveZeroes(int[] nums) {
        // index of the leftmost zero
        int leftMostZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // swap, i != leftMostZero in particular
                if (i > leftMostZero) {
                    nums[leftMostZero] = nums[i];
                    nums[i] = 0;
                }
                // after swap (or no swap at all)
                leftMostZero++;
            }
        }
    }
}
