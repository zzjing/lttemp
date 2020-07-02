
public class EntryRemover {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int curLength = nums.length;
        while (i < curLength) {
            if (nums[i] == val) {
                // swap an entry to remove with the last entry anyways
                nums[i] = nums[curLength - 1];
                curLength--; // shrink the length: move the right pointer leftwards
            } else {
                i++; // no need to remove: advance the left pointer
            }
        }
        return curLength;
    }
}
