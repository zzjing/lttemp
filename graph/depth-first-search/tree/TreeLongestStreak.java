
public class TreeLongestStreak {
    private int maxConsec;
    public int longestConsecutive(TreeNode root) {
        maxConsec = 0;
        if (root == null) {
            return 0;
        }
        longestConsecutive(root, root.val, 0);
        return maxConsec;
    }

    private void longestConsecutive(TreeNode root, int prev, int streak) {
        if (root == null) {
            return;
        }
        if (root.val == prev + 1) {
            streak++;
        } else {
            streak = 1;
        }
        maxConsec = Math.max(streak, maxConsec);
        longestConsecutive(root.left, root.val, streak);
        longestConsecutive(root.right, root.val, streak);
    }
}
