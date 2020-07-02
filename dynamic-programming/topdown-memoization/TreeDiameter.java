import java.util.HashMap;
import java.util.Map;

public class TreeDiameter {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int rootDm = maxDepth(root.left) + maxDepth(root.right);
        int leftDm = diameterOfBinaryTree(root.left);
        int rightDm = diameterOfBinaryTree(root.right);
        return Math.max(rootDm, Math.max(leftDm, rightDm));
    }

    private int maxDepth(TreeNode root) {
        Map<TreeNode, Integer> nodeToVal = new HashMap<TreeNode, Integer>();
        return maxDepth(root, nodeToVal);
    }

    private int maxDepth(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        memo.put(root, 1 + Math.max(maxDepth(root.left, memo), maxDepth(root.right, memo)));
        return memo.get(root);
    }
}
