
public class TreePreInBuilder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, 0, inorder.length - 1, preorder, inorder);
    }
    // we do not include a preEnd
    // because we use element as the root from preorder array one step at a time
    // as for inorder array, it is always split to two halves
    private TreeNode buildTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode curRoot = new TreeNode(preorder[preStart]);
        int inorderRoot = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == curRoot.val) {
                inorderRoot = i;
            }
        }
        curRoot.left = buildTree(preStart + 1, inStart, inorderRoot - 1, preorder, inorder);
        // inorderRootPos - inStart = len of the left subtree (later move 1 step to the right tree)
        int leftTreeLen = inorderRoot - inStart;
        curRoot.right = buildTree(preStart + leftTreeLen + 1, inorderRoot + 1, inEnd, preorder, inorder);
        return curRoot;
    }
}
