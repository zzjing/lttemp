
class BalancedTreeCheck {
public:
    bool isBalanced(TreeNode* root) {
        if (root == NULL) {
            return true;
        }
        if (abs(getMaxDepth(root->left) - getMaxDepth(root->right)) > 1) {
            return false;
        }
        return isBalanced(root->left) && isBalanced(root->right);
    }

private:
    int getMaxDepth(TreeNode* root) {
        if (root == NULL) {
            return 0;
        }
        return 1 + max(getMaxDepth(root->left), getMaxDepth(root->right));
    }
};
