
public class TreeCompleteness {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean metLastLeaf = false;
        Queue<TreeNode> traversal = new LinkedList<>();
        traversal.offer(root);
        while (!traversal.isEmpty()) {
            TreeNode current = traversal.poll();
            if (current == null) {
                metLastLeaf = true;
            } else {
                if (metLastLeaf) {
                    return false;
                }
                traversal.add(current.left);
                traversal.add(current.right);
            }
        }
        return true;
    }
}
