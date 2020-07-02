
class Solution {
public:
    int diameterOfBinaryTree(TreeNode* root) {
        maxDm = 0;
        getMaxDepth(root);
        return maxDm;
    }

private:
    int maxDm;
    int getMaxDepth(TreeNode* root) {
        if (root == NULL) {
            return 0;
        }
        int leftDm = getMaxDepth(root->left);
        int rightDm = getMaxDepth(root->right);
        maxDm = max(leftDm + rightDm, maxDm);
        return 1 + max(leftDm, rightDm);
    }
};
