import java.util.ArrayList;
import java.util.List;

public class TreeGraphCheck {
    public boolean validTree(int n, int[][] edges) {
        List[] graph = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < edges.length; i++) {
            int edgeU = edges[i][0];
            int edgeV = edges[i][1];
            graph[edgeU].add(edgeV);
            graph[edgeV].add(edgeU);
        }
        if (hasCycle(graph, visited, 0, -1)) {
            return false;
        }
        // ensure that there is no isolated vertex in the graph
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(List[] graph, boolean[] visited, int start, int prev) {
        visited[start] = true;
        for (int i = 0; i < graph[start].size(); i++) {
            int nextVertex = (int) graph[start].get(i);
            if ((visited[nextVertex] && prev != nextVertex) ||
                (!visited[nextVertex] && hasCycle(graph, visited, nextVertex, start))) {
                return true;
            }
        }
        return false;
    }
}
