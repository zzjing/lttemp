
class PathSumCheck {
public:
    bool hasPathSum(TreeNode* root, int sum) {
        if (root == NULL) {
            return false;
        }
        if (root->left == NULL && root->right == NULL) {
            return (sum - root->val == 0);
        }
        sum -= root->val;
        return hasPathSum(root->left, sum) || hasPathSum(root->right, sum);
    }
};
