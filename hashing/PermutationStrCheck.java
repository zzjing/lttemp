
public class PermutationStrCheck {
    public boolean arePermutations(String A, String B) {
        if (A == null && B == null) {
            return true;
        } else if (A == null || B == null) {
            return false;
        } else if (A.length() != B.length()) {
            return false;
        }
        int[] charCount = new int[256];
        for (int i = 0; i < A.length(); i++) {
            char curA = A.charAt(i);
            char curB = B.charAt(i);
            charCount[curA]++;
            charCount[curB]--;
        }
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
