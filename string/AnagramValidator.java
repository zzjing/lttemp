
public class AnagramValidator {
    public boolean isAnagram(String s, String t) {
        char[] sArray = new char[26];
        for (int i = 0; i < s.length(); i++) {
            sArray[s.charAt(i) - 'a']++;
        }
        char[] tArray = new char[26];
        for (int i = 0; i < t.length(); i++) {
            tArray[t.charAt(i) - 'a']++;
        }
        String sortedS = new String(sArray);
        String sortedT = new String(tArray);
        return (sortedS.equals(sortedT));
    }

    public boolean checkAnagram(String s, String t) {
        // sorting solution; time O(nlog n), space O(n).
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] != tArray[i]) {
                return false;
            }
        }
        return true;
    }
}
