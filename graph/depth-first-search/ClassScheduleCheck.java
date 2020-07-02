import java.util.ArrayList;
import java.util.List;

public class ClassScheduleCheck {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] courseGraph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courseGraph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int current = prerequisites[i][0];
            int advanced = prerequisites[i][1];
            courseGraph[current].add(advanced);
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            // explore the graph by passing the graph, markers, vertex to start
            if (!dfsFinish(courseGraph, visited, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfsFinish(List[] courseGraph, boolean[] visited, int course) {
        // a cycle is detected
        if (visited[course]) {
            return false;
        }
        visited[course] = true;
        for (int i = 0; i < courseGraph[course].size(); i++) {
            int adjacent = (int) courseGraph[course].get(i);
            if (!dfsFinish(courseGraph, visited, adjacent)) {
                return false;
            }
        }
        // backtrack when we can search no further
        // i.e. otherwise cannot search other branches
        visited[course] = false;
        return true;
    }
}
