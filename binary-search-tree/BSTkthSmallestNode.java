
public class BSTkthSmallestNode {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return -1;
        }
        int leftSubNodes = countSubtreeNodes(root.left);
        if (leftSubNodes >= k) { // keep traversing down until there're k - 1 nodes left
            return kthSmallest(root.left, k);
        } else if (leftSubNodes < k - 1) { // not enough nodes in left branch alone
            // 1 is counted as current node
            return kthSmallest(root.right, k - leftSubNodes - 1);
        }
        return root.val;
    }

    private int countSubtreeNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countSubtreeNodes(root.left) + countSubtreeNodes(root.right);
    }
    /*
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return -1;
        }
        List<Integer> sortedArray = new ArrayList<Integer>();
        traverse(root, sortedArray);
        return sortedArray.get(k - 1);
    }

    private void traverse(TreeNode root, List<Integer> sortedArray) {
        if (root == null) {
            return;
        }
        traverse(root.left, sortedArray);
        sortedArray.add(root.val);
        traverse(root.right, sortedArray);
    } */
}
