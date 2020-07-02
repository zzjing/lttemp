import java.util.Arrays;

public class ArrayBSTconversion {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        // Arrays.sort(nums);
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int rootPos = start + (end - start) / 2;
        int rootVal = nums[rootPos];
        TreeNode curRoot = new TreeNode(rootVal);
        curRoot.left = buildBST(nums, start, rootPos - 1);
        curRoot.right = buildBST(nums, rootPos + 1, end);
        return curRoot;
    }
}
