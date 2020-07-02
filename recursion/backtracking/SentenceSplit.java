/**
 * Splits a string input (without spaces) into a meaningful
 * sentence with words separated by spaces.
 * 
 * @author Zezhou Jing (modified from Adam Blank's CSE 143 lecture)
 * University of Washington
 * October 3, 2016
 */
import java.util.Set;

public class SentenceSplit {
    public String splitSentence(String sentence, Set<String> dict) {
        // base case
    	// looks up a string in the given dictionary
    	if (dict.contains(sentence)) {
    	    return sentence;
    	}
    	// attempts to split the given string character by character until a word
    	// in the dictionary occurs
    	for (int i = sentence.length() - 1; i > 0; i--) {
    	    // left part of the string
    	    String leftStr = sentence.substring(0, i);
    	    // right part of the string
    	    String rightStr = sentence.substring(i, sentence.length());
    	    // base case is trivial when the left part if not a word
    	    // otherwise tries to split the remainder of the sentence (right) recursively
    	    if (dict.contains(leftStr)) {
                rightStr = splitSentence(rightStr, dict);
                // if a legitimate word from the right part is returned by the base case
                // above (which is of course not null), the we split the sentence correctly
                if (rightStr != null) {
                    return leftStr + " " + rightStr;
                }
                // undoes (backtracks) the choice by going back to the sentence
            }
        }
        // cannot split any further
    	return null;
    }
}
