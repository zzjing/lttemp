import java.util.HashMap;
import java.util.Map;

public class GraphCloning {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> labelToCopy = new HashMap<>();
        return cloneGraph(node, labelToCopy);
    }

    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node,
        Map<Integer, UndirectedGraphNode> labelToCopy) {
        if (node == null) {
            return null;
        }
        if (labelToCopy.containsKey(node.label)) {
            return labelToCopy.get(node.label);
        }
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        labelToCopy.put(copy.label, copy);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor, labelToCopy));
        }
        return copy;
    }
}
