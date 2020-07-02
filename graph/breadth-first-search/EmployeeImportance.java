import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0 || id <= 0 || id > employees.size()) {
            return 0;
        }
        Collections.sort(employees, (a, b) -> a.id - b.id);
        int importance = 0;
        Queue<Employee> subord = new LinkedList<Employee>();
        subord.offer(employees.get(id - 1));
        while (!subord.isEmpty()) {
            int numOfSubs = subord.size();
            for (int i = 0; i < numOfSubs; i++) {
                Employee current = subord.poll();
                importance += current.importance;
                int nextLayer = current.subordinates.size();
                if (nextLayer != 0) {
                    for (int j = 0; j < nextLayer; j++) {
                        subord.offer(employees.get(current.subordinates.get(j) - 1));
                    }
                }
            }
        }
        return importance;
    }
}
