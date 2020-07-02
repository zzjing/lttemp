import java.util.ArrayList;
import java.util.List;

public class LevelMaxValue {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> valSet = new ArrayList<Integer>();
        getEachLevel(root, 0, valSet);
        return valSet;
    }

    private void getEachLevel(TreeNode root, int curLevel, List<Integer> valSet) {
        if (root == null) {
            return;
        }
        // add the first node of each level to the list
        // note the level starts from 0 s.t. the overall root is added once
        if (curLevel == valSet.size()) {
            valSet.add(root.val);
        } else {
            valSet.set(curLevel, Math.max(root.val, valSet.get(curLevel)));
        }
        getEachLevel(root.left, curLevel + 1, valSet);
        getEachLevel(root.right, curLevel + 1, valSet);
    }
}
