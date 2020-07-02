
public class SegmentCount {
    // use methods from the String class
    public int countSegments(String s) {
        String trimStr = s.trim();
        if (trimStr.length() == 0) {
            return 0;
        }
        return trimStr.split("\\s+").length;
    }

    // traditional scanning method without modifying the string
    // Complexities: O(n) time, O(1) space
    public int getCount(String s) {
        int segments = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                segments++;
            }
        }
        return segments;
    }
}
