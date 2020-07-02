import java.util.Stack;

public class BackspaceStringCheck {
    public boolean equalsBackspace(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int bsp1 = 0;
        int bsp2 = 0;
        while (i >= 0 && j >= 0) {
            char cur1 = s1.charAt(i);
            char cur2 = s2.charAt(j);
            // read backspace operators
            if (cur1 == '_') {
                bsp1++;
                i--;
            }
            if (cur2 == '_') {
                bsp2++;
                j--;
            }
            // delete characters
            if (cur1 != '_' && bsp1 > 0) {
                i--;
                bsp1--;
            }
            if (cur2 != '_' && bsp2 > 0) {
                j--;
                bsp2--;
            }
            if (cur1 != '_' && cur2 != '_'
                && bsp1 == 0 && bsp2 == 0 && cur1 != cur2 ) {
                return false;
            }
            if (cur1 != '_' && cur2 != '_'
                && bsp1 == 0 && bsp2 == 0 && cur1 == cur2 ) {
                i--;
                j--;
            }
        }
        return (i == j);
    }

    public boolean backspaceEquals(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        String str1 = process(s1);
        String str2 = process(s2);
        return str1.equals(str2);
    }

    private String process(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> charSaver = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (charSaver.isEmpty() && cur == '_') {
                return "error";
            } else if (!charSaver.isEmpty() && cur == '_') {
                charSaver.pop();
            } else {
                charSaver.push(cur);
            }
        }
        while (!charSaver.isEmpty()) {
            sb.append(charSaver.pop());
        }
        return sb.reverse().toString();
    }
}
