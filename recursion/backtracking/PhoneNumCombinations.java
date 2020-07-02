/**
 * Outputs all letter combinations a given phone number
 * can represent from reading the phone pad.
 * 
 * @author Zezhou Jing
 * University of Washington
 * October 3, 2016
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class PhoneNumCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> letterComb = new LinkedList<>();
        // boundary case, input is empty
        if (digits == null || digits.length() == 0) {
            return letterComb;
        }
        // implement a phone pad
        Map<Character, char[]> pad = new HashMap<>();
        pad.put('0', new char[] {});
        pad.put('1', new char[] {});
        pad.put('2', new char[] {'a', 'b', 'c'});
        pad.put('3', new char[] {'d', 'e', 'f'});
        pad.put('4', new char[] {'g', 'h', 'i'});
        pad.put('5', new char[] {'j', 'k', 'l'});
        pad.put('6', new char[] {'m', 'n', 'o'});
        pad.put('7', new char[] {'p', 'q', 'r', 's'});
        pad.put('8', new char[] {'t', 'u', 'v'});
        pad.put('9', new char[] {'w', 'x', 'y', 'z'});
        StringBuilder builder = new StringBuilder();
        getCombinations(digits, letterComb, pad, builder);
        return letterComb;
    }

    private void getCombinations(String digits, List<String> letterComb,
        Map<Character, char[]> pad, StringBuilder builder) {
        // base case, we have one legit combination
    	if (builder.length() == digits.length()) {
    	    letterComb.add(builder.toString());
    	    return; // exit
        }
        // generate combinations
        // ensures letter choices are from corresponding sets
    	for (char c : pad.get(digits.charAt(builder.length()))) {
            builder.append(c);
            getCombinations(digits, letterComb, pad, builder);
            // undo the last choice
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
