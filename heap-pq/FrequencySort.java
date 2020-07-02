import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Map<Character, Integer> charToFreq = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (charToFreq.containsKey(current)) {
                charToFreq.put(current, charToFreq.get(current) + 1);
            } else {
                charToFreq.put(current, 1);
            }
        }
        PriorityQueue<Map.Entry<Character, Integer>> freqMaxHeap =
            new PriorityQueue<Map.Entry<Character, Integer>>((a, b) -> (b.getValue() - a.getValue()));
        freqMaxHeap.addAll(charToFreq.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!freqMaxHeap.isEmpty()) {
            Map.Entry<Character, Integer> curPair = freqMaxHeap.poll();
            for (int i = 0; i < curPair.getValue(); i++) {
                sb.append(curPair.getKey());
            }
        }
        return sb.toString();
    }
}
