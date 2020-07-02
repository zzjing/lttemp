import java.util.Stack;

public class NnaryTreePreorderCheck {
    public boolean isPreorder(TreeNode[] order) {
        if (order == null || order.length == 0) {
          return true;
        }
        Stack<TreeNode> preorder = new Stack<>();
        if (order[0].parent != null) {
            return false;
        }
        preorder.push(order[0]);
        for (TreeNode current : order) {
            while (!preorder.isEmpty() && current.parent != preorder.peek()) {
                preorder.pop();
            }
            if (preorder.isEmpty()) {
                return false;
            }
            preorder.push(current);
        }
        return true;
    }
}
