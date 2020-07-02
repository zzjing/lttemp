import java.util.HashSet;
import java.util.Set;

public class VowelsReversal {
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        char[] strArr = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (vowels.contains(strArr[left]) && vowels.contains(strArr[right])) {
                char tmp = strArr[left];
                strArr[left] = strArr[right];
                strArr[right] = tmp;
                left++;
                right--;
            } else if (vowels.contains(strArr[left]) && !vowels.contains(strArr[right])) {
                right--;
            } else if (!vowels.contains(strArr[left]) && vowels.contains(strArr[right])) {
                left++;
            } else {
                left++;
                right--;
            }
        }
        return new String(strArr);
    }
}
