
public class ArrayDuplicatesRemoval {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        // return new length, note zero-based index
        return i + 1;
    }

    public int deleteDuplicates(int[] nums) {
        int curUnique = 0;
        for (int n : nums) {
            if (curUnique == 0 || n > nums[curUnique - 1]) {
                nums[curUnique] = n;
                curUnique++;
            }
        }
        return curUnique;
    }

    public int removeDuoDuplicates(int[] nums) {
        int curUnique = 0;
        for (int n : nums) {
            if (curUnique < 2 || n > nums[curUnique - 2]) {
                nums[curUnique] = n;
                curUnique++;
            }
        }
        return curUnique;
    }
}
