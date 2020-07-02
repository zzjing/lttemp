
public class ColorSort {
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 1) {
            return;
        }
        int firstNotRed = 0;
        int lastNotBlue = nums.length - 1;
        for (int i = 0; i <= lastNotBlue; i++) {
            while (nums[i] == 2 && i < lastNotBlue) {
                swap(nums, i, lastNotBlue);
                lastNotBlue--;
            }
            while (nums[i] == 0 && i > firstNotRed) {
                swap(nums, i, firstNotRed);
                firstNotRed++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
