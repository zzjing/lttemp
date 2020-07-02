import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class TreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        if (root == null) {
            return inorder;
        }
        Stack<TreeNode> traversal = new Stack<>();
        TreeNode current = root;
        while (!traversal.isEmpty() || current != null) {
            if (current != null) {
                traversal.push(current);
                current = current.left;
            } else {
                TreeNode btmLeft = traversal.pop();
                inorder.add(btmLeft.val);
                current = btmLeft.right;
            }
        }
        return inorder;
    }
        /*
        Stack<TreeNode> dfsPath = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || !dfsPath.isEmpty()) {
            while (current != null) {
                dfsPath.push(current);
                current = current.left;
            }
            current = dfsPath.pop();
            inorder.add(current.val);
            current = current.right;
        }
        return inorder; *?

}
