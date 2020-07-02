import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TimeStringQueue {
    public Queue<Timenode> getTimeStringQueue(Queue<Timenode> sortedTimeNodes) {
        if (sortedTimeNodes == null || sortedTimeNodes.size() == 0) {
            return new LinkedList<>();
        }
        Map<String, Double> strToTime = new HashMap<>();
        Queue<Timenode> timeStrQueue = new LinkedList<>();
        while (!sortedTimeNodes.isEmpty()) {
            Timenode curNode = sortedTimeNodes.remove();
            if (!strToTime.containsKey(curNode.label)) {
                strToTime.put(curNode.label, curNode.time);
            } else {
                if (curNode.time - strToTime.get(curNode.label) > 10) {
                    timeStrQueue.offer(curNode);
                    strToTime.put(curNode.label, curNode.time);
                }
            }
        }
        return timeStrQueue;
    }
}
