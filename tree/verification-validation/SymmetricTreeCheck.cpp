
class SymmetricTreeCheck {
public:
    bool isSymmetric(TreeNode* root) {
        return checkSub(root, root);
    }

private:
    bool checkSub(TreeNode* leftSub, TreeNode* rightSub) {
        if (leftSub == NULL && rightSub == NULL) {
            return true;
        } else if (leftSub == NULL || rightSub == NULL) {
            return false;
        } else if (leftSub->val != rightSub->val) {
            return false;
        }
        return checkSub(leftSub->left, rightSub->right) &&
            checkSub(leftSub->right, rightSub->left);
    }

    bool isSymmetric(TreeNode* root) {
        if (root == NULL) {
            return true;
        }
        return checkSub(root->left, root->right);
    }

    bool checkSub(TreeNode* leftSub, TreeNode* rightSub) {
        if (leftSub == NULL && rightSub == NULL) {
            return true;
        } else if (leftSub == NULL || rightSub == NULL) {
            return false;
        } else if (leftSub->val != rightSub->val) {
            return false;
        }
        return checkSub(leftSub->left, rightSub->right) &&
            checkSub(leftSub->right, rightSub->left);
    }
};
