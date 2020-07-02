
public class TreePathNumSum {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int curSum) {
        if (root == null) {
            return 0;
        }
        // pattern: for each new number we encounter
        // we append it to the right of previous sum: (prev)sum * 10 + root.val
        if (root.left == null && root.right == null) {
            return curSum * 10 + root.val;
        }
        curSum = curSum * 10 + root.val;
        return sumNumbers(root.left, curSum) + sumNumbers(root.right, curSum);
    }
}
