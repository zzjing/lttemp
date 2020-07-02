import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class IndexMapping {
    public int[] anagramMappings(int[] A, int[] B) {
        if (A == null || B == null || A.length != B.length) {
            return new int[0];
        }
        Map<Integer, List<Integer>> numToAnagram = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            if (!numToAnagram.containsKey(B[i])) {
                numToAnagram.put(B[i], new LinkedList<>());
            }
            numToAnagram.get(B[i]).add(i);
        }
        int[] anagramIndices = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            anagramIndices[i] = numToAnagram.get(A[i]).get(0);
            numToAnagram.get(A[i]).remove(0);
        }
        return anagramIndices;
    }
}
