
public class EveryWordReverser {
    public String reverseWords(String s) {
        char[] sArray = s.toCharArray();
        int i = 0;
        for (int j = 0; j < sArray.length; j++) {
            // once encounters a space, reverse the word before it
            if (sArray[j] == ' ') {
                reverse(sArray, i, j - 1);
                // move the cursor to the next word
                i = j + 1;
            }
        }
        // reverse the last word in string (fence post problem)
        reverse(sArray, i, sArray.length - 1);
        return new String(sArray);
    }

    private void reverse(char[] sArray, int left, int right) {
        while (left < right) {
            char temp = sArray[left];
            sArray[left] = sArray[right];
            sArray[right] = temp;
            left++;
            right--;
        }
    }
}
