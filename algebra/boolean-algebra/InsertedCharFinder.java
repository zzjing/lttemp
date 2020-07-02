
public class InsertedCharFinder {
    public char findInsertion(String original, String inserted) {
        if (original == null || inserted == null) {
            return ' ';
        }
        char insertChar = ' ';
        for (int i = 0; i < original.length(); i++) {
            insertChar ^= original.charAt(i);
        }
        for (int i = 0; i < inserted.length(); i++) {
            insertChar ^= inserted.charAt(i);
        }
        return insertChar;
    }
}
