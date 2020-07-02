
public class HIndex {
    // Solution using bucket sort/hash map; O(n) time and O(n) space
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        // number of papers published
        int papers = citations.length;
        // number of papers with at least i citations
        int atLeast = 0;
        // a researcher's h index must not exceed the number of papers published
        int[] hIndices = new int[papers + 1];
        for (int i = 0; i < papers; i++) {
            // for any paper with reference >= papers, we put in the n-th bucket
            // this potentially leads to highest h-index possible (No. of papers)
            if (citations[i] >= papers) {
                hIndices[papers]++;
            } else {
                hIndices[citations[i]]++;
            }
        }
        for (int i = papers; i >= 0; i--) {
            atLeast += hIndices[i];
            // by definition of the h-index
            if (atLeast >= i) {
                return i;
            }
        }
        return 0;
    }
}
