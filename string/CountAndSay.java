
public class CountAndSay {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String seq = "1";
        // generate the nth sequence based on each other
        for (int i = 1; i < n; i++) {
            seq = generateSeq(seq);
        }
        return seq;
    }

    private String generateSeq(String seq) {
        StringBuilder sb = new StringBuilder();
        char prev = seq.charAt(0);
        int count = 1;
        // count from the second character
        for (int i = 1; i < seq.length(); i++) {
            // count
            if (seq.charAt(i) == prev) {
                count++;
            } else { // otherwise say
                sb.append(count);
                sb.append(prev);
                // move on to the next subsequence
                prev = seq.charAt(i);
                count = 1;
            }
        }
        // say the last subsequence
        sb.append(count);
        sb.append(prev);
        return sb.toString();
    }
}
