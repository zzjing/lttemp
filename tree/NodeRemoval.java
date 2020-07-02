
public class NodeRemoval {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else { // root.val = key; remove current node
            if (root.left == null) { // only right subtree exists
                return root.right; // return its right subtree
            } else if (root.right == null) {
                return root.left;
            } // current node has both left and right subtrees
            TreeNode buffer = root;
            root = root.left;
            getRightLeaf(buffer.left).right = buffer.right;
        }
        return root;
    }

    private TreeNode getRightLeaf(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public TreeNode removeNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = removeNode(root.left, key);
        } else if (root.val < key) {
            root.right = removeNode(root.right, key);
        } else {
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else { // has both left and right subtrees
                int minValRight = findReplacement(root.right); // one valid replacement value
                root.val = minValRight;
                root.right = removeNode(root.right, minValRight);
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
