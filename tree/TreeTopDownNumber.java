
public class TreeTopDownNumber {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // pattern: for each new number we encounter
        // we append it to the right of previous sum: (prev)sum * 10 + root.val
        if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        }
        int currentSum = sum * 10 + root.val;
        return sumNumbers(root.left, currentSum) + sumNumbers(root.right, currentSum);
    }
}
