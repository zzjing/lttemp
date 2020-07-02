import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLvTraversalBtmUp {
    public List<List<Integer>> levelOrderBottomUp(TreeNode root) {
        List<List<Integer>> levelBottomUp = new LinkedList<>();
        if (root == null) {
            return levelBottomUp;
        }
        Queue<TreeNode> treeBFS = new LinkedList<>();
        treeBFS.offer(root);
        while (!treeBFS.isEmpty()) {
            int levelSize = treeBFS.size();
            List<Integer> layer = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = treeBFS.poll();
                layer.add(current.val);
                if (current.left != null) {
                    treeBFS.offer(current.left);
                }
                if (current.right != null) {
                    treeBFS.offer(current.right);
                }
            }
            levelBottomUp.add(layer);
        }
        Collections.reverse(levelBottomUp);
        return levelBottomUp;
    }
}
