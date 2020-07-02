import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLevelMaxValFinder {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxVals = new ArrayList<Integer>();
        if (root == null) {
            return maxVals;
        }
        Queue<TreeNode> treeBFS = new LinkedList<TreeNode>();
        treeBFS.offer(root);
        while (!treeBFS.isEmpty()) {
            int layerSize = treeBFS.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < layerSize; i++) {
                TreeNode parent = treeBFS.poll();
                max = Math.max(parent.val, max);
                if (parent.left != null) {
                    treeBFS.offer(parent.left);
                }
                if (parent.right != null) {
                    treeBFS.offer(parent.right);
                }
            }
            maxVals.add(max);
        }
        return maxVals;
    }
}
