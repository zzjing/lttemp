import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLevelAvg {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<Double>();
        Queue<TreeNode> bfsTree = new LinkedList<TreeNode>();
        bfsTree.offer(root);
        while (!bfsTree.isEmpty()) {
            int lvSize = bfsTree.size();
            Double average = 0.0;
            for (int i = 0; i < lvSize; i++) {
                TreeNode parent = bfsTree.poll();
                average += parent.val;
                if (parent.left != null) {
                    bfsTree.offer(parent.left);
                }
                if (parent.right != null) {
                    bfsTree.offer(parent.right);
                }
            }
            averages.add(average / lvSize);
        }
        return averages;
    }
}
