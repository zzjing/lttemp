/**
 * Check if a binary trees is symmetric in structure.
 * That is, its left subtree is the same as the right one.
 *
 * @author Zezhou Jing, University of Washington
 * @date July 3, 2016
 */

public class SymmetricTreeCheck {
    // Recursive method with a helper function
    public boolean isSymmetric(TreeNode root) {
        return checkSubtrees(root, root);
    }
    // Check if subtrees are symmetric.
    // Implementation is almost the same as isSameTree function.
    private boolean checkSubtrees(TreeNode p, TreeNode q) {
        // base cases
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        // check left (sub)subtrees and right (sub)subtrees are the same\
        // note the order of parameters
        return checkSubtrees(p.left, q.right) && checkSubtrees(p.right, q.left);
    }

    public bool isSymmetric(Node root) {
        return isSymmetric(root, root);
    }
    
    public bool isSymmetric(Node n1, Node n2) {
        if (n1 == null && n2 == null) {
          return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        if (n1.value != n2.value || n1.children.size() != n2.children.size()) {
          return false;
        }
        int size = n1.children.size();
        for (int i = 0; i < size; i++) {
          if (!isSymmetric(n1.children.get(i), n2.children.get(size - 1 - i))) {
            return false;
          }
        }
        return true;
    }

    public boolean checkSymmetric(TreeNode root) {
-        if (root == null) {
-            return true;
-        }
-        Queue<TreeNode> treeBFS = new LinkedList<>();
-        treeBFS.offer(root);
-        treeBFS.offer(root);
-        while (!treeBFS.isEmpty()) {
-            TreeNode left = treeBFS.poll();
-            TreeNode right = treeBFS.poll();
-            if (left == null && right == null) {
-                continue;
-            }
-            if (left == null || right == null) {
-                return false;
-            }
-            if (left.val != right.val) {
-                return false;
-            }
-            treeBFS.offer(left.left);
-            treeBFS.offer(right.right);
-            treeBFS.offer(left.right);
-            treeBFS.offer(right.left);
-        }
-        return true;
-    }
}
