import java.util.ArrayList;
import java.util.List;

public class SafeNodesFinder {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return new ArrayList<>();
        }
        // three types of marks: 0 - not yet visited
        // 1 - visited and is part of a cycle
        // 2 - visited but not part of a cycle (safe)
        int[] marks = new int[graph.length];
        var safeNodes = new ArrayList<Integer>();
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, i, marks)) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    private boolean dfs(int[][] graph, int curNode, int[] marks) {
        if (marks[curNode] > 0) {
            return (marks[curNode] == 2);
        }
        // mark the current node as visited, will change it if not going into cycles
        marks[curNode] = 1;
        for (int i = 0; i < graph[curNode].length; i++) {
            int neighbor = graph[curNode][i];
            // a normal visited node from the previous rounds of dfs: skip it
            if (marks[curNode] == 2) {
                continue;
            }
            // a visited node that is a part of a cycle, return false
            if (marks[neighbor] == 1 || !dfs(graph, neighbor, marks)) {
                return false;
            }
        }
        // fully explored all of its neighbors without going into a cycle
        marks[curNode] = 2;
        return true;
    }
}
