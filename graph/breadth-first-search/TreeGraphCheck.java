import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeGraphCheck {
    public boolean validTree(int n, int[][] edges) {
        List[] graph = new ArrayList[n];
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < edges.length; i++) {
            int edgeU = edges[i][0];
            int edgeV = edges[i][1];
            graph[edgeU].add(edgeV);
            graph[edgeV].add(edgeU);
        }
        Queue<Integer> bfsGraph = new LinkedList<Integer>();
        bfsGraph.offer(0);
        visited[0] = 1;
        while (!bfsGraph.isEmpty()) {
            int current = (int) bfsGraph.poll();
            for (int i = 0; i < graph[current].size(); i++) {
                int nextNhbr = (int) graph[current].get(i);
                if (visited[nextNhbr] == 1) {
                    return false;
                }
                if (visited[nextNhbr] == 0) {
                    bfsGraph.offer(nextNhbr);
                    visited[nextNhbr]++;
                }
            }
            // mark the layer/level starting from the current vertex as complete
            // such that its neighbor will not backtrack (since the edge is undirected)
            visited[current] = 2;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
