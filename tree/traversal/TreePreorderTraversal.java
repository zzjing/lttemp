import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        if (root == null) {
            return preorder;
        }
        Stack<TreeNode> traversal = new Stack<>();
        TreeNode current = root;
        while (!traversal.isEmpty() || current != null) {
            if (current != null) {
                traversal.push(current);
                preorder.add(current.val);
                current = current.left;
            } else {
                TreeNode btmLeft = traversal.pop();
                current = btmLeft.right;
            }
        }
        return preorder;
    }

    public List<Integer> preorder(Node root) {
        List<Integer> preorder = new ArrayList<>();
        if (root == null) {
            return preorder;
        }
        Stack<Node> traversal = new Stack<>();
        traversal.push(root);
        while (!traversal.isEmpty()) {
            Node current = traversal.pop();
            preorder.add(current.val);
            for (int i = current.children.size() - 1; i >= 0; i--) {
                traversal.push(current.children.get(i));
            }
        }
        return preorder;
    }
        /*
        List<Integer> preorder = new ArrayList<Integer>();
        if (root == null) {
            return preorder;
        }
        Stack<TreeNode> traverse = new Stack<TreeNode>();
        traverse.push(root);
        while (!traverse.isEmpty()) {
            TreeNode curRoot = traverse.pop();
            preorder.add(curRoot.val);
            if (curRoot.right != null) {
                traverse.push(curRoot.right);
            }
            if (curRoot.left != null) {
                traverse.push(curRoot.left);
            }
        }
        return preorder; */
}
