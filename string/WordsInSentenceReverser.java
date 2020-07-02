
public class WordsInSentenceReverser {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        reverse(s, 0, s.length - 1);
        int start = 0;
        int end = 0; 
        for (int i = 0; i < s.length; i++) {
            // encounters a space, reverse the word ahead of it
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                // move the start cursor to the first char of the next word
                start = i + 1;
            }
        }
        // reverse the last word as it does not have a space following it
        reverse(s, start, s.length - 1);
    }

    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
