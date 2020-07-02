import java.util.ArrayList;
import java.util.List;

public class RepeatedStringPartition {
    public List<Integer> partitionLabels(String S) {
        List<Integer> partitionLen = new ArrayList<>();
        int[] charIndex = new int[26];
        // record the index of the last occurance of a char
        for (int i = 0; i < S.length(); i++) {
            char current = S.charAt(i);
            charIndex[current - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); i++) {
            int lastIndex = S.charAt(i) - 'a';
            if (i != charIndex[lastIndex]) {
                // adjust the end of the window to its last occurance
                if (charIndex[lastIndex] > end) {
                    end = charIndex[lastIndex];
                }
            } else if (i == end) {
                // reaches the end of a window, add its length
                partitionLen.add(end - start + 1);
                start = end + 1;
                end = end + 1;
            }
        }
        return partitionLen;
    }
}
