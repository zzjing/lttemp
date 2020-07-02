import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopFrequencies {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (k > nums.length) {
            return null;
        }
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (freq.containsKey(nums[i])) {
                freq.put(nums[i], freq.get(nums[i]) + 1);
            } else {
                freq.put(nums[i], 1);
            }
        }
        // initialize a max priority queue
        PriorityQueue<Map.Entry<Integer, Integer>> maxPQ = 
                         new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer,Integer> pair: freq.entrySet()){
            maxPQ.add(pair);
        }
        List<Integer> kElements = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            int kFreq = maxPQ.poll().getKey();
            kElements.add(kFreq);
        }
        return kElements;
    }
}
