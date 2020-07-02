import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphCheck {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return true;
        }
        int[] vertexColor = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (vertexColor[i] != 0) {
                continue;
            }
            Queue<Integer> bfsGraph = new LinkedList<>();
            bfsGraph.offer(i);
            vertexColor[i] = 1;
            while (!bfsGraph.isEmpty()) {
                int current = bfsGraph.poll();
                for (int neighbor : graph[current]) {
                    if (vertexColor[neighbor] == 0) {
                        vertexColor[neighbor] = -vertexColor[current];
                        bfsGraph.offer(neighbor);
                    } else if (vertexColor[neighbor] != -vertexColor[current]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
