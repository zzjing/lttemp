import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidTreeCheck {
    public boolean isValidTree(TreeNode[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return falsTreeNode    }
        Map<TreeNode, TreeNode> childToParent = new HashMap<>();
        for (TreeNode node : nodes) {
            if (!childToParent.containsKey(node)) {
                childToParent.put(node, null);
            }
            List<TreeNode> kids = node.children;
            for (TreeNode child : kids) {
                if (!childToParent.containsKey(child)) {
                    childToParent.put(child, node);
                } else if (childToParent.get(child) != null) {
                    return false; // cycle
                }
            }
        }
        // check if there exists exactly one root
        boolean uniqueRoot = false;
        for (TreeNode node : childToParent.keySet()) {
            if (childToParent.get(node) == null && !uniqueRoot) {
                uniqueRoot = true;
            } else if (childToParent.get(node) == null && uniqueRoot) {
                return false;
            }
        }
        return true;
    }
}
