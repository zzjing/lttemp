
public class LogSort {
    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length <= 1) {
            return logs;
        }
        Comparator<String> logComparator = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                int preLog1 = str1.indexOf(' ');
                int preLog2 = str2.indexOf(' ');
                char log1 = str1.charAt(preLog1 + 1);
                char log2 = str2.charAt(preLog2 + 1);
                if (log1 <= '9') {
                    if (log2 <= '9') {
                        return 0; // tie since we need to preserve order
                    } else {
                        return 1; // digit log should be placed after letter ones
                    }
                }
                // if log2 is a digit while log1 is not, place it after log1
                if (log2 <= '9') {
                    return -1;
                }
                // otherwise compare letter logs
                int compareLetter =
                    str1.substring(preLog1 + 1).compareTo(str2.substring(preLog2 + 1));
                if (compareLetter == 0) { // if tied, break tie with label
                    return str1.substring(0, log1).compareTo(str2.substring(0, log2));
                }
                return compareLetter;
            }
        };
        Arrays.sort(logs, logComparator);
        return logs;
    }
}
