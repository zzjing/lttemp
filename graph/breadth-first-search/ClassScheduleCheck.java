import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ClassScheduleCheck {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] courseGraph = new ArrayList[numCourses];
        int[] courseDegree = new int[numCourses];
        Queue<Integer> bfsGraph = new LinkedList<>();
        int canTake = 0;
        for (int i = 0; i < numCourses; i++) {
            courseGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int prereq = prerequisites[i][0];
            int advanced = prerequisites[i][1];
            courseDegree[advanced]++;
            // a more advanced course is a neighbor of a prereq
            courseGraph[prereq].add(advanced);
        }
        for (int i = 0; i < numCourses; i++) {
            // basic 101 courses have no prereqs; i.e. level == 0
            if (courseDegree[i] == 0) {
                bfsGraph.offer(i); // we search from the most basic courses
                canTake++; // they can be taken at once
            }
        }
        while (!bfsGraph.isEmpty()) {
            // take a course, browse through its neighbors
            int course = (int) bfsGraph.poll();
            for (int i = 0; i < courseGraph[course].size(); i++) {
                int nextCourse = (int) courseGraph[course].get(i);
                // "collapsing edge:" mark a next course as visited
                // by decrease its edge degree
                courseDegree[nextCourse]--;
                // if current edge being removed is the only one
                // *pointing to* that next course, move to that course
                if (courseDegree[nextCourse] == 0) {
                    bfsGraph.offer(nextCourse);
                    canTake++; // move to it, mark it as accessible
                }
                // BFS reaches "sink vertices" in the last level.
                // Whenever the graph contains a cycle, it will never
                // reach those courses! A full traversal thus fails.
            }
        }
        return (canTake == numCourses);
    }
}
