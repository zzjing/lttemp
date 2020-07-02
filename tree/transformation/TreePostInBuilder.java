
public class TreePostInBuilder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }
    // we do not include a postEnd
    // because we use element as the root from postorder array one step at a time (right to left)
    // post-order construction; as for inorder array, it is always split to two halves
    private TreeNode buildTree(int postStart, int inStart, int inEnd, int[] inorder, int[] postorder) {
        if (postStart < 0 || inStart > inEnd) {
            return null;
        }
        TreeNode curRoot = new TreeNode(postorder[postStart]);
        int inorderRoot = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == curRoot.val) {
                inorderRoot = i;
            }
        }
        curRoot.right = buildTree(postStart - 1, inorderRoot + 1, inEnd, inorder, postorder);
        int rightTreeLen = inEnd - inorderRoot;
        int leftTreePost = postStart - rightTreeLen - 1;
        curRoot.left = buildTree(leftTreePost, inStart, inorderRoot - 1, inorder, postorder);
        return curRoot;
    }
}
