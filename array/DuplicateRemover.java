
public class DuplicateRemover {
    public int removeDuplicates(int[] nums) {
        // two pointer solution, c.f. other removal problems
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = nums.length;
        for (int i = 0, j = 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                size--;
            } else {
                i++;
                // sets nums[i] to itself if it is not a duplicate (i = j)
                nums[i] = nums[j];
            }
        }
        return size;
    }
}
