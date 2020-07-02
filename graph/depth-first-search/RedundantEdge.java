import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RedundantEdge {
    private Set<Integer> visited;
    private int MAX_EDGE_VAL;
    public int[] findRedundantConnection(int[][] edges) {
        visited = new HashSet<>();
        MAX_EDGE_VAL = 1000;
        List<Integer>[] treeGraph = new ArrayList[MAX_EDGE_VAL + 1];
        for (int i = 0; i <= MAX_EDGE_VAL; i++) {
            treeGraph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            visited.clear();
            // search if we can reach the vertex v from vertex u
            // *before adding the edge (u, v) to the graph, if so, it's a redundant conn
            int edgeU = edge[0];
            int edgeV = edge[1];
            if (!treeGraph[edgeU].isEmpty() && !treeGraph[edgeV].isEmpty() &&
                dfsPath(treeGraph, edgeU, edgeV)) {
                return edge;
            } // undirected graph
            treeGraph[edgeU].add(edgeV);
            treeGraph[edgeV].add(edgeU);
        }
        return new int[0];
    }

    private boolean dfsPath(List<Integer>[] treeGraph, int source, int target) {
        if (!visited.contains(source)) {
            visited.add(source);
            if (source == target) {
                return true;
            }
            for (int neighbor : treeGraph[source]) {
                if (dfsPath(treeGraph, neighbor, target)) {
                    return true;
                }
            }
        }
        return false;
    }
}
