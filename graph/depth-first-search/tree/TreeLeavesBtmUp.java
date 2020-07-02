import java.util.ArrayList;
import java.util.List;

public class TreeLeavesBtmUp {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> levelLeaves = new ArrayList<List<Integer>>();
        findLeaves(root, levelLeaves);
        return levelLeaves;
    }
    
    private int findLeaves(TreeNode root, List<List<Integer>> levelLeaves) {
        if (root == null) {
            return -1; // this way, the leaf level would have a level of 0
        }
        int leftLv = findLeaves(root.left, levelLeaves);
        int rightLv = findLeaves(root.right, levelLeaves);
        int level = 1 + Math.max(leftLv, rightLv);
        if (levelLeaves.size() == level) {
            levelLeaves.add(new ArrayList<Integer>());
        }
        levelLeaves.get(level).add(root.val);
        root.left = null;
        root.right = null; // actually remove leaves
        return level;
    }
}
