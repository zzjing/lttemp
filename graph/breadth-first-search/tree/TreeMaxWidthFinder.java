import java.util.LinkedList;
import java.util.Queue;

public class TreeMaxWidthFinder {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> bfsTree = new LinkedList<TreeNode>();
        Queue<Integer> indices = new LinkedList<Integer>();
        bfsTree.offer(root);
        indices.offer(0); // index for the root is 0
        int maxWidth = 1;
        int leftKid = 0;
        int rightKid = 0;
        while (!bfsTree.isEmpty()) {
            int layerSize = bfsTree.size();
            for (int i = 0; i < layerSize; i++) {
                TreeNode parent = bfsTree.poll();
                int currentIndex = indices.poll();
                if (i == 0) { // leftmost child
                    leftKid = currentIndex;
                }
                if (i == layerSize - 1) { // rightmost child
                    rightKid = currentIndex;
                }
                if (parent.left != null) {
                    bfsTree.offer(parent.left);
                    indices.offer(currentIndex * 2);
                }
                if (parent.right != null) {
                    bfsTree.offer(parent.right);
                    indices.offer(currentIndex * 2 + 1);
                }
            }
            maxWidth = Math.max(maxWidth, rightKid - leftKid + 1);
        }
        return maxWidth;
    }
}
