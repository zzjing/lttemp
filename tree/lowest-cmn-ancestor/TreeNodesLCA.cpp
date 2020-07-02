class TreeNodesLCA {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == NULL || root == p || root == q) {
            return root;
        }
        TreeNode* searchLeft = lowestCommonAncestor(root->left, p, q);
        TreeNode* searchRight = lowestCommonAncestor(root->right, p, q);
        if (searchLeft == NULL) {
            return lowestCommonAncestor(searchRight, p, q);
        } else if (searchRight == NULL) {
            return lowestCommonAncestor(searchLeft, p, q);
        } else {
            return root;
        }
    }
};
