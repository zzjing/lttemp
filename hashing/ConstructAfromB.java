
public class ConstructAfromB {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] charFrequency = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            charFrequency[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            charFrequency[ransomNote.charAt(i) - 'a']--;
            if (charFrequency[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
