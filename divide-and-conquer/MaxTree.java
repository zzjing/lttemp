
public class MaxTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        // parameter is not maxIndex - 1 since nums.length is excluded in the loop
        return constructTree(nums, 0, nums.length);
    }

    private TreeNode constructTree(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }
        int maxIndex = maxIndex(nums, left, right);
        TreeNode root = new TreeNode(nums[maxIndex]);
        // parameter is not maxIndex - 1 since maxIndex is excluded in the loop
        root.left = constructTree(nums, left, maxIndex);
        root.right = constructTree(nums, maxIndex + 1, right);
        return root;
    }

    private int maxIndex(int[] nums, int left, int right) {
        int maxIndex = left; // i < right exclude "right"
        for (int i = left; i < right; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
