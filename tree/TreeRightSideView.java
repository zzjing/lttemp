import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> sideView = new LinkedList<>();
        rightSideView(root, 0, sideView);
        return sideView;
    }

    private void rightSideView(TreeNode root, int depth, List<Integer> sideView) {
        if (root == null) {
            return;
        }
        if (sideView.size() == depth) {
            sideView.add(root.val);
        }
        rightSideView(root.right, depth + 1, sideView);
        rightSideView(root.left, depth + 1, sideView);
    }
}
