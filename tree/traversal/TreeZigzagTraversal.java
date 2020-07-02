import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeZigzagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagOrder = new LinkedList<>();
        if (root == null) {
            return zigzagOrder;
        }
        Queue<TreeNode> bfsTree = new LinkedList<>();
        boolean leftToRight = true;
        bfsTree.offer(root);
        while (!bfsTree.isEmpty()) {
            int levelSize = bfsTree.size();
            List<Integer> layer = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = bfsTree.poll();
                if (leftToRight) {
                    layer.add(current.val);
                } else if (!leftToRight) {
                    layer.add(0, current.val);
                }
                if (current.left != null) {
                    bfsTree.offer(current.left);
                }
                if (current.right != null) {
                    bfsTree.offer(current.right);
                }
            }
            zigzagOrder.add(layer);
            leftToRight = !leftToRight;
        }
        return zigzagOrder;
    }
}
