
public class SortedHIndex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        // number of papers published
        int papers = citations.length;
        // find a minimum i such that citations[i] >= papers - i
        // return maximum (papers - i), which is possible numbers of papers with more citations
        int start = 0;
        int end = citations.length - 1;
        // remember the definition of h-index
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // the remaining papers have no more than citations[mid] (definition)
            if (citations[mid] == papers - mid) {
                return papers - mid;
            } else if (citations[mid] < papers - mid) {
                start = mid + 1;
            } else { // suffices to be an h-index, but have to find the largest h-index
                end = mid - 1;
            }
        }
        return papers - start;
    }
}
