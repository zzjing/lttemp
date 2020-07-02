import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ScheduleOrdering {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List[] courseGraph = new ArrayList[numCourses];
        int[] courseDegree = new int[numCourses];
        int[] topoOrder = new int[numCourses];
        int topoIndex = 0;
        Queue<Integer> bfsGraph = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            courseGraph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int prereq = prerequisites[i][1];
            int advanced = prerequisites[i][0];
            courseDegree[advanced]++;
            // a more advanced course is a neighbor of a prereq
            courseGraph[prereq].add(advanced);
        }
        for (int i = 0; i < numCourses; i++) {
            // basic 101 courses have no prereqs; i.e. level == 0
            if (courseDegree[i] == 0) {
                bfsGraph.offer(i); // we search from the most basic courses
                topoOrder[topoIndex] = i;
                topoIndex++;
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
                    topoOrder[topoIndex] = nextCourse;
                    topoIndex++;
                    // move to it, mark it as accessible
                }
            }
        }
        if (topoIndex == numCourses) {
            return topoOrder;
        } else {
            return new int[0];
        }
    }
}
