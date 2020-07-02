import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        } else if (n == 0) {
            return tasks.length;
        }
        int[] taskToFreq = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            taskToFreq[tasks[i] - 'A']++;
        }
        PriorityQueue<Integer> instancesLeft =
            new PriorityQueue<>(26, (a, b) -> (b - a));
        for (int i = 0; i < taskToFreq.length; i++) {
            if (taskToFreq[i] > 0) {
                instancesLeft.add(taskToFreq[i]);
            }
        }
        int exeTime = 0;
        while (!instancesLeft.isEmpty()) {
            int curCooling = 0;
            List<Integer> tmp = new ArrayList<>();
            while (curCooling <= n) {
                if (!instancesLeft.isEmpty()) {
                    int curTask = instancesLeft.poll();
                    if (curTask > 1) {
                        tmp.add(curTask - 1);
                    }
                }
                exeTime++;
                if (instancesLeft.isEmpty() && tmp.size() == 0) {
                    return exeTime;
                }
                curCooling++;
            }
            for (int tasksLeft : tmp) {
                instancesLeft.add(tasksLeft);
            }
        }
        return exeTime;
    }
}
