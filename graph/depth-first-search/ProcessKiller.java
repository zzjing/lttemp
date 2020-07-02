import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProcessKiller {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        if (kill == 0) { // if kill the overall parent process, all ps are gone
            return pid;
        }
        int processNum = pid.size();
        // parent process id --> process ids
        Map<Integer, Set<Integer>> treeGraph = new HashMap<>();
        // construct the tree-graph structure by going through 
        for (int i = 0; i < processNum; i++) {
            treeGraph.put(pid.get(i), new HashSet<Integer>());
        }
        for (int i = 0; i < processNum; i++) {
            int curParent = ppid.get(i);
            if (treeGraph.containsKey(curParent)) {
                // add a corresponding children process to current parent process
                Set<Integer> children = treeGraph.get(curParent);
                children.add(pid.get(i));
                treeGraph.put(curParent, children); // update the graph
            }
        }
        List<Integer> pidKilled = new ArrayList<>();
        // dfsGraph with the process to kill as the starting point
        dfsTraverse(treeGraph, pidKilled, kill);
        return pidKilled;
    }

    private void dfsTraverse(Map<Integer, Set<Integer>> treeGraph, List<Integer> pidKilled, int pid) {
        pidKilled.add(pid); // first kill the start process; then proceed with typical dfs
        Set<Integer> children = treeGraph.get(pid);
        for (Integer childProcess : children) {
            dfsTraverse(treeGraph, pidKilled, childProcess);
        }
    }
}
