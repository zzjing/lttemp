import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        // reverse the process of preorder traversal
        List<Integer> postorder = new LinkedList<>();
        if (root == null) {
            return postorder;
        }
        Stack<TreeNode> traversal = new Stack<>();
        TreeNode current = root;
        while (!traversal.isEmpty() || current != null) {
            if (current != null) {
                traversal.push(current);
                postorder.add(0, current.val);
                current = current.right;
            } else {
                TreeNode btmRight = traversal.pop();
                current = btmRight.left;
            }
        }
        return postorder;
    }

    public List<Integer> postorder(Node root) {
        List<Integer> postorder = new ArrayList<>();
        if (root == null) {
            return postorder;
        }
        Stack<Node> traversal = new Stack<>();
        traversal.push(root);
        while (!traversal.isEmpty()) {
            Node current = traversal.pop();
            postorder.add(current.val);
            for (Node child : current.children) {
                traversal.push(child);
            }
        }
        Collections.reverse(postorder);
        return postorder;
    }
}
