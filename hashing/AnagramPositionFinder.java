import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramPositionFinder {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pFreq = new int[26];
        int[] sFreq = new int[26];
        List<Integer> indices = new ArrayList<Integer>();
        for (int i = 0; i < p.length(); i++) {
            int position = p.charAt(i) - 'a';
            pFreq[position]++;
        }
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            for (int j = 0; j < p.length(); j++) {
                int position = s.charAt(i + j) - 'a';
                sFreq[position]++;
            }
            boolean match = true;
            for (int k = 0; k < 26; k++) {
                if (pFreq[k] != sFreq[k]) {
                    match = false;
                }
            }
            if (match) {
                indices.add(i);
            }
            Arrays.fill(sFreq, 0);
        }
        return indices;
    }
}
