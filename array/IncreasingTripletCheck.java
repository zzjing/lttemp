
public class IncreasingTripletCheck {
    // O(n) time, O(1) space solution with two pointers.
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        // to check if such increasing triplet subsequence (not necessarily consecutive) exists
        // we only have to find two bigger elements than a small one in order
        int smallest = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= smallest) {
                // update smallest if current element is smaller than both
                smallest = nums[i];
            } else if (nums[i] <= middle) {
                // update middle if current element is bigger than smallest
                middle = nums[i];
            } else {
                // we find two bigger elements in order
                return true;
            }
        }
        return false;
    }
}
