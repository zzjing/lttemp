public class Python_Indentation_Validation {
    public boolean validate(String[] lines) {
        Stack<String> codeBuffer = new Stack<>();
        for (String line : lines) {
            int blockLevel = getIndentNum(line);
            // check first line, stack is initially empty
            if (codeBuffer.isEmpty()) {
                if (blockLevel != 0) { // first line, must be 0 indents
                    // print out line
                    return false;
                }
            } else if (codeBuffer.peek().charAt(codeBuffer.peek().length() - 1) == ':') { // ends with control :
                if (blockLevel != getIndentNum(codeBuffer.peek()) + 1) { // must be one indent more than last line's
                    // print out line
                    return false;
                }
            } else {
                // if one "nested" statement block finishes, pop all nested lines with more indents
                while (!codeBuffer.isEmpty() && getIndentNum(codeBuffer.peek()) > blockLevel) {
                    codeBuffer.pop();
                }
                // after removal of last code block, indents do not agree
                if (getIndentNum(codeBuffer.peek()) != blockLevel) {
                    // print out line
                    return false;
                }
            }
            codeBuffer.push(line);
        }
        return true;
    }

    // if n spaces = 1 tab, return res / n - get how many leading indents
    private int getIndentNum(String line) {
        int indents = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '\t') {
                indents++;
            } else {
                break;
            }
        }
        return indents;
    }
}