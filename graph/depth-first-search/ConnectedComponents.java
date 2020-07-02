import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        if (n < 0) {
            return 0;
        }
        List[] islandGraph = new ArrayList[n];
        for (int i = 0; i < islandGraph.length; i++) {
            islandGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            islandGraph[start].add(end);
            islandGraph[end].add(start);
        }
        boolean[] visited = new boolean[n];
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(islandGraph, i, visited);
                components++;
            }
        }
        return components;
    }

    private void dfs(List[] islandGraph, int start, boolean[] visited) {
        visited[start] = true;
        for (int i = 0; i < islandGraph[start].size(); i++) {
            int nextVertex = (int) islandGraph[start].get(i);
            if (!visited[nextVertex]) {
                dfs(islandGraph, nextVertex, visited);
            }
        }
    }
}
