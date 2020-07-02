import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeRightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightVal = new ArrayList<Integer>();
        rightSideView(root, rightVal, 0);
        return rightVal;
    }

    private void rightSideView(TreeNode root, List<Integer> rightVal, int depth) {
        if (root == null) {
            return;
        }
        if (rightVal.size() == depth) {
            rightVal.add(root.val);
        }
        rightSideView(root.right, rightVal, depth + 1);
        rightSideView(root.left, rightVal, depth + 1);
    }
}
