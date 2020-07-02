
public class LabelPartition {
    public List<Integer> partitionLabels(String S) {
        List<Integer> partitionLen = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return partitionLen;
        }
        int[] charLastOccurance = new int[26];
        for (int i = 0; i < S.length(); i++) {
            char current = S.charAt(i);
            charLastOccurance[current - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); i++) {
            char current = S.charAt(i);
            end = Math.max(end, charLastOccurance[current - 'a']);
            if (i == end) {
                partitionLen.add(end - start + 1);
                start = end + 1;
            }
        }
        return partitionLen;
    }
}
