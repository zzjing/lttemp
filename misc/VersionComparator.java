
public class VersionComparator {
    // O(m) time - m is the length of the string with longer length
    public int compareVersion(String version1, String version2) {
        String[] versionOne = version1.split("\\.");
        String[] versionTwo = version2.split("\\.");
        // must compare digit by digit
        int i = 0;
        while (i < versionOne.length || i < versionTwo.length) {
            if (i < versionOne.length && i < versionTwo.length) {
                if (Integer.parseInt(versionOne[i]) < Integer.parseInt(versionTwo[i])) {
                    return -1;
                } else if (Integer.parseInt(versionOne[i]) > Integer.parseInt(versionTwo[i])) {
                    return 1;
                }
            // which version is longer?
            } else if (i < versionOne.length && Integer.parseInt(versionOne[i]) != 0) {
                return 1;
            } else if (i < versionTwo.length && Integer.parseInt(versionTwo[i]) != 0) {
                return -1;
            }
            i++;
        }
        return 0;
    }
}
