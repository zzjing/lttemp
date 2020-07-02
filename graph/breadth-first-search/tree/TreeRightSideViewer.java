import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeRightSideViewer {
    // BFS solution; Time complexity O(n), spaceO(n)
    public List<Integer> rightSideView(nTreeNode root) {
        List<Integer> rightVal = new ArrayList<Integer>();
        if (root == null) {
            return rightVal;
        }
        Queue<TreeNode> treeBFS = new LinkedList<TreeNode>();
        treeBFS.offer(root);
        while (!treeBFS.isEmpty()) {
            int levelSize = treeBFS.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode parent = treeBFS.poll();
                // the rightmost node of each layer
                if (i == 0) {
                    rightVal.add(parent.val);
                }
                if (parent.right != null) {
                    treeBFS.offer(parent.right);
                }
                if (parent.left != null) {
                    treeBFS.offer(parent.left);
                }
            }
        }
        return rightVal;
    }
}
