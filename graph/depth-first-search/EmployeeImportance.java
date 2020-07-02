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
        return dfsImportance(employees, id);
    }

    private int dfsImportance(List<Employee> employees, int id) {
        int importance = 0;
        Employee current = employees.get(id - 1);
        int numsOfSubord = current.subordinates.size();
        for (int i = 0; i < numsOfSubord; i++) {
            int currentID = current.subordinates.get(i);
            importance += dfsImportance(employees, currentID);
        }
        return importance + current.importance;
    }
    
    // alternative solution using a global variable
    /*
    private int importance;
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0 || id <= 0 || id > employees.size()) {
            return 0;
        }
        Collections.sort(employees, (a, b) -> a.id - b.id);
        dfsImportance(employees, id);
        return importance;
    }

    private void dfsImportance(List<Employee> employees, int id) {
        Employee current = employees.get(id - 1);
        importance += current.importance;
        int numOfSubord = employees.get(id - 1).subordinates.size();
        if (numOfSubord == 0) {
            return;
        }
        for (int i = 0; i < numOfSubord; i++) {
            int currentID = current.subordinates.get(i);
            dfsImportance(employees, currentID);
        }
    }
    */
}
