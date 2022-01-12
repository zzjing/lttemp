// c.f. Leetcode 297
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BTtoArray {
    private getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }
    // heap compression via bfs
    public int[] compressDenseTree(TreeNode root) {
        int height = getHeight(root);
        if (height == 0) {
            return new int[0];
        }
        // dense tree: null node's respective index stores default value 0
        int arrayLength = (int) Math.pow(2, height);
        int[] heap = new int[arrayLength];
        Queue<TreeNode> bfsBuffer = new LinkedList<>();
        bfsBuffer.offer(root);
        Queue<TreeNode> indexBuffer = new LinkedList<>();
        indexBuffer.offer(0); // or 1 (2i, 2i + 1); otherwise (2i + 1, 2i + 2)
        while (!bfsBuffer.isEmpty()) {
            TreeNode current = bfsBuffer.poll();
            Integer currentIndex = indexBuffer.poll();
            heap[currentIndex] = current.val;
            if (current.left != null) {
                bfsBuffer.offer(current.left);
                indexBuffer.offer(2 * currentIndex + 1);
            }
            if (current.right != null) {
                bfsBuffer.offer(current.right);
                indexBuffer.offer(2 * currentIndex + 2);
            }
        }
        return heap;
    }
    // one entry pair = 8 bytes vs. 12 bytes of tree node
    public Map<Integer, Integer> compressSparseTree(TreeNode root) {
        Map<Integer, Integer> record = new HashMap<>();
        if (root == null) {
            return record;
        }
        Queue<TreeNode> bfsBuffer = new LinkedList<>();
        bfsBuffer.offer(root);
        Queue<Integer> indexBuffer = new LinkedList<>();
        indexBuffer.offer(0);
        while (!bfsBuffer.isEmpty()) {
            TreeNode current = bfsBuffer.poll();
            Integer currentIndex = indexBuffer.poll();
            record.put(currentIndex, current.val);
            if (current.left != null) {
                bfsBuffer.offer(current.left);
                indexBuffer.offer(2 * currentIndex + 1);
            }
            if (current.right != null) {
                bfsBuffer.offer(current.right);
                indexBuffer.offer(2 * currentIndex + 2);
            }
        }
        return record;
    }
} // Time O(n) Space O(n)
