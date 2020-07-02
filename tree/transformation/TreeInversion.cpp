class TreeInversion {
public:
    TreeNode* invertTree(TreeNode* root) {
        if (root == NULL) {
            return root;
        }
        invert(root);
        return root;
    }

private:
    void invert(TreeNode* root) {
        TreeNode* tmp = root -> left;
        root -> left = root -> right;
        root -> right = tmp;
        if (root -> left != NULL) {
            invert(root -> left);
        }
        if (root -> right != NULL) {
            invert(root -> right);
        }
    }
};
