
public class TreeRobber {
    public int rob(TreeNode root) {
        int[] maxMoney = robSub(root);
        // entry [0] denotes that the root is not robbed
        // entry [1] denotes that the root is robbed
        return Math.max(maxMoney[0], maxMoney[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] moneyOfLeft = robSub(root.left);
        int[] moneyOfRight = robSub(root.right);
        int[] maxMoney = new int[2];
        // if current root is not robbed, then maximize from robbing the left children
        // or not robbing the left children; same applies for right children
        maxMoney[0] = Math.max(moneyOfLeft[0], moneyOfLeft[1]) +
            Math.max(moneyOfRight[0], moneyOfRight[1]);
        // if current root is robbed, then we must not rob its left and right children
        maxMoney[1] = root.val + moneyOfLeft[0] + moneyOfRight[0];
        return maxMoney;
    }
}
