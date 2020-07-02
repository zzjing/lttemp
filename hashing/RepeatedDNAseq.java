import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RepeatedDNAseq {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10) {
            return new LinkedList<>();
        }
        Set<String> dnaSeq = new HashSet<>();
        Set<String> repeatedFast = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String curDNA = s.substring(i, i + 10);
            if (dnaSeq.contains(curDNA)) {
                repeatedFast.add(curDNA);
            } else {
                dnaSeq.add(curDNA);
            }
        }
        return new LinkedList<>(repeatedFast);
    }
}
