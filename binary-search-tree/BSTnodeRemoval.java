
public class BSTnodeRemoval {
    // none of the methods below achieves AVL balance
    // less balanced BST
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                TreeNode minRightSub = root.right;
                while (minRightSub.left != null) {
                    minRightSub = minRightSub.left;
                }
                minRightSub.left = root.left;
                return root.right;
            }
        }
        return root;
    }
    // more balanced BST
    public TreeNode removeNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else { // has both left and right subtrees
                int minValRight = findReplacement(root.right); // one valid replacement value
                root.val = minValRight;
                root.right = deleteNode(root.right, minValRight);
            }
        }
        return root;
    }

    private int findReplacement(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
