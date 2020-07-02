import java.util.ArrayList;
import java.util.List;

public class SingleRowTyper {
    public String[] findWords(String[] words) {
        String[] rows = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        List<String> typeWords = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            String rWord = words[i];
            String word = rWord.toUpperCase();
            char current = word.charAt(0);
            if (rows[0].indexOf(current) != -1) {
                boolean canType = true;
                for (int j = 1; j < word.length(); j++) {
                    if (rows[0].indexOf(word.charAt(j)) == -1) {
                        canType = false;
                    }
                }
                if (canType) {
                    typeWords.add(rWord);
                }
                continue;
            }
            if (rows[1].indexOf(current) != -1) {
                boolean canType = true;
                for (int j = 1; j < word.length(); j++) {
                    if (rows[1].indexOf(word.charAt(j)) == -1) {
                        canType = false;
                    }
                }
                if (canType) {
                    typeWords.add(rWord);
                }
                continue;
            }
            if (rows[2].indexOf(current) != -1) {
                boolean canType = true;
                for (int j = 1; j < word.length(); j++) {
                    if (rows[2].indexOf(word.charAt(j)) == -1) {
                        canType = false;
                    }
                }
                if (canType) {
                    typeWords.add(rWord);
                }
                continue;
            }
        }
        String[] output = new String[typeWords.size()];
        int index = 0;
        for (String typed : typeWords) {
            output[index] = typed;
            index++;
        }
        return output;
    }
}
