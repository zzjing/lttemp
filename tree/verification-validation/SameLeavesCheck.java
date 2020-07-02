
public class SameLeavesCheck {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    private void getLeaves(TreeNode root, List<Integer> leaves) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                leaves.add(root.val);
            }
            getLeaves(root.left, leaves);
            getLeaves(root.right, leaves);
        }
    }
}
