
public class TreeRobber {
    public int rob(TreeNode root) {
        return robSub(root, new HashMap<>());
    }

    private int robSub(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        int maxMoney = 0;
        // cases in which the current root is robbed
        if (root.left != null) {
            maxMoney += robSub(root.left.left, memo) + robSub(root.left.right, memo);
        }
        if (root.right != null) {
            maxMoney += robSub(root.right.left, memo) + robSub(root.right.right, memo);
        }
        // compare two methods of robbery: to rob the current root, or not to rob the current root
        maxMoney = Math.max(maxMoney + root.val, robSub(root.left, memo) + robSub(root.right, memo));
        memo.put(root, maxMoney);
        return maxMoney;
    }
}
