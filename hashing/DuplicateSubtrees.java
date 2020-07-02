import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> dups = new LinkedList<>();
        if (root == null) {
            return dups;
        }
        Map<String, List<TreeNode>> subtreeToOccur = new HashMap<>();
        serialize(root, subtreeToOccur);
        for (List<TreeNode> occurances : subtreeToOccur.values()) {
            if (occurances.size() > 1) {
                dups.add(occurances.get(0));
            }
        }
        return dups;
    }

    private String serialize(TreeNode root, Map<String, List<TreeNode>> subtreeToOccur) {
        if (root == null) {
            return "";
        }
        String subtree = "(" + serialize(root.left, subtreeToOccur) + root.val
            + serialize(root.right, subtreeToOccur) + ")";
        if (!subtreeToOccur.containsKey(subtree)) {
            subtreeToOccur.put(subtree, new LinkedList<>());
        }
        subtreeToOccur.get(subtree).add(root);
        return subtree;
    }
}
