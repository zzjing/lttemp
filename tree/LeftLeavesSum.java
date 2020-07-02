
public class LeftLeavesSum {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null) {
            // reaches a left leaf
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
            // continues to recurse toward left while saving the intermediate result
                sum += sumOfLeftLeaves(root.left);
            }
        } // must not add an else statement here
        sum += sumOfLeftLeaves(root.right);
        // returns sum at this level
        return sum;
    }

    public int leftLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // reaches a left leaf node
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + leftLeavesSum(root.right);
        }
        // traverse toward left subtrees and right subtrees
        return leftLeavesSum(root.left) + leftLeavesSum(root.right);
    }
}
