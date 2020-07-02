import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShiftedStrCatagorizer {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> sftGroups = new ArrayList<>();
        if (strings == null || strings.length == 0) {
            return sftGroups;
        }
        Map<String, List<String>> wordToSft = new HashMap<>();
        for (String str : strings) {
            int offset = str.charAt(0) - 'a';
            String sftKey = "";
            for (int i = 0; i < str.length(); i++) {
                char cur = (char) (str.charAt(i) - offset);
                if (cur < 'a') {
                    cur += 26;
                }
                sftKey += cur;
            }
            if (!wordToSft.containsKey(sftKey)) {
                wordToSft.put(sftKey, new ArrayList<>());
            }
            wordToSft.get(sftKey).add(str);
        }
        for (String sftKey : wordToSft.keySet()) {
            List<String> toSort = wordToSft.get(sftKey);
            Collections.sort(toSort);
            sftGroups.add(toSort);
        }
        return sftGroups;
    }
}
