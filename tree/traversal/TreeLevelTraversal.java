import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeLevelTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lvOrder = new ArrayList<>();
        if (root == null) {
            return lvOrder;
        }
        Queue<TreeNode> bfsTree = new ArrayList<>();
        bfsTree.offer(root);
        while (!bfsTree.isEmpty()) {
            int layerSize = bfsTree.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < layerSize; i++) {
                TreeNode current = bfsTree.poll();
                layer.add(current.val);
                if (current.left != null) {
                    bfsTree.offer(current.left);
                }
                if (current.right != null) {
                    bfsTree.offer(current.right);
                }
            }
            lvOrder.add(layer);
        }
        return lvOrder;
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (root == null) {
            return levelOrder;
        }
        Queue<Node> traversal = new LinkedList<>();
        traversal.offer(root);
        while (!traversal.isEmpty()) {
            int levelSize = traversal.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node current = traversal.poll();
                layer.add(current.val);
                for (Node child : current.children) {
                    traversal.offer(child);
                }
            }
            levelOrder.add(layer);
        }
        return levelOrder;
    }
}
