import java.util.LinkedList;
import java.util.Queue;

public class TreeMinDepthFinder {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> treeBFS = new LinkedList<TreeNode>();
        treeBFS.offer(root);
        int minDepth = 1;
        while (!treeBFS.isEmpty()) {
            int levelSize = treeBFS.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode parent = treeBFS.poll();
                if (parent.left == null && parent.right == null) {
                    return minDepth;
                }
                if (parent.left != null) {
                    treeBFS.offer(parent.left);
                }
                if (parent.right != null) {
                    treeBFS.offer(parent.right);
                }
            }
            minDepth++;
        }
        return minDepth;
    }
}
