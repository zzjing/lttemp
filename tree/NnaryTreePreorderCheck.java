import java.util.Stack;

public class NnaryTreePreorderCheck {
    public boolean isPreorder(TreeNode[] order) {
        if (order == null || order.length == 0) {
          return true;
        }
        Stack<TreeNode> preorder = new Stack<TreeNode>();
        if (order[0].parent != null) {
            return false;
        }
        preorder.push(order[0]);
        for (TreeNode current : order) {
            // once we encounter a node whose parent is not the last node in stack
            // we have already moved to another branch of the subtree
            // whose parent node is already in the stack, pop until we find it
            while (!preorder.isEmpty() && current.parent != preorder.peek()) {
                preorder.pop();
                // be aware we need to keep that parent node (if found)
                // because it may have other children branches
            }
            if (preorder.isEmpty()) {
                return false;
            }
            // need to push the current node to the stack in case it has children nodes
            preorder.push(current);
        }
        return true;
    }
}
