import java.util.ArrayList;
import java.util.List;

public class StrParlinPartition {
    public List<List<String>> partition(String s) {
        List<List<String>> validPartns = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return validPartns;
        }
        partition(s, validPartns, new ArrayList<String>(), 0);
        return validPartns;
    }

    private void partition(String s, List<List<String>> validPartns,
        List<String> partn, int start) {
        // base case is the start position of a word to check is
        // at the end of the string s.t. all previous words are palins
        if (start == s.length()) {
            validPartns.add(new ArrayList<String>(partn));
            return;
        }
        // the end index to substring a word can get beyond boundary
        for (int end = start + 1; end <= s.length(); end++) {
            String current = s.substring(start, end);
            //  re-extract a word if it's an invalid palindrome
            if (!isPalindrome(current)) {
                continue;
            }
            partn.add(current);
            // operate on the remaining part of string
            // by starting at the end position
            partition(s, validPartns, partn, end);
            partn.remove(partn.size() - 1); // backtrack
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
