public List<String> wordWrap(String[] words, int limit) {
    List<String> wrapped = new ArrayList<>();
    if (words == null || words.length == 0) {
        return wrapped;
    }
    int i = 0;
    while (i < words.length) {
        int lenRemain = limit;
        int count = 0;
        while (i < words.length) {
            if (lenRemain - word[i] < 0) {
                break;
            }
            count++;
            lenRemain -= words[i].length + 1;
            i++;
        }
        // wrapped.add(Arrays.asList(words).subList(i - count, i);
        for (int j = i - count; j < i; j++) {
            wrapped.add(words[j]);
            wrapped.add("-");
        }
    }
    return wrapped;
}

private static List justifyText(List<String> texts, int textLength) {
    // findRight: Then we greedily try to go as far right as possible until we fill our current line.
    // Then we justify one line at a time.
    // justify: In all cases we pad the right side with spaces until we reach max width for the line;
    // If it's one word then it is easy, the result is just that word.
    // If it's the last line then the result is all words separated by a single space.
    // Otherwise we calculate the size of each space evenly and if there is a remainder
    // we distribute an extra space until it is gone

    // reads every line
    List<String> modifiedTexts = new ArrayList<>();
    for (String text : texts) {
        String[] splits = text.split("\s+");
        for (String word : splits) {
            modifiedTexts.add(word);
        }
    }
    // processes everyline
    int currWordIndex = 0;
    int wordStartIndex, wordEndIndex = 0;

    List<String> result = new ArrayList<>();
    while (wordEndIndex < modifiedTexts.size()) {
        int currentLineLen = 0;
        wordStartIndex = currWordIndex;
        wordEndIndex = currWordIndex;

        while(wordEndIndex < modifiedTexts.size()
                && currentLineLen + modifiedTexts.get(wordEndIndex).length() + wordEndIndex - wordStartIndex <= textLength) {
            currentLineLen += modifiedTexts.get(wordEndIndex).length();
            wordEndIndex++;
        }
        int spacesArraySize = wordEndIndex - wordStartIndex - 1;
        currentLineLen += spacesArraySize;

        int[] spaces = new int[spacesArraySize];  // size can be zero
        Arrays.fill(spaces, 1);

        if (currentLineLen < textLength) {
            int spacesToBeDistributed = textLength - currentLineLen;
            if (spaces.length != 0) {
                for(int i = 0, j = 0; i < spacesToBeDistributed; ++i, j = (j + 1) % spacesArraySize) {
                    spaces[j]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = wordStartIndex; i < wordEndIndex; ++i) {
            sb.append(modifiedTexts.get(i));
            for(int times = 0; i < wordEndIndex - 1 && times < spaces[i - wordStartIndex]; ++times) {
                sb.append(" ");
            }
        }
        result.add(sb.toString());
        currWordIndex = wordEndIndex;
    }
    return result;
}