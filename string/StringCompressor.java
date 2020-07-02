
public class StringCompressor {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int curIndex = 0;
        int length = 0;
        while (curIndex < chars.length) {
            char toCompress = chars[curIndex];
            int charCount = 0;
            while (curIndex < chars.length && chars[curIndex] == toCompress) {
                charCount++;
                curIndex++;
            }
            chars[length] = toCompress;
            length++;
            if (charCount != 1) {
                char[] counts = Integer.toString(charCount).toCharArray();
                for (int i = 0; i < counts.length; i++) {
                    chars[length] = counts[i];
                    length++;
                }
            }
        }
        return length;
    }
}
