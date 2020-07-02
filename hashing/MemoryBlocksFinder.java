import java.util.ArrayList;
import java.util.HashSet;

public class MemoryBlocksFinder {
    public int countBlocks(ListNode[] cache) {
        if (cache == null || cache.length == 0) {
            return 0;
        }
        int blocks = 0;
        var inCache = new HashSet<ListNode>();
        for (int i = 0; i < cache.length; i++) {
            ListNode cur = cache[i];
            if (cur != null) {
                inCache.add(cur);
            }
        }
        for (int i = 0; i < cache.length; i++) {
            ListNode cur = cache[i];
            if (!inCache.contains(cur.next)) {
                blocks++;
            }
        }
        return blocks;
    }

    public int countBlocksWithJunk(ListNode[] cache) {
        if (cache == null || cache.length == 0) {
            return 0;
        }
        int blocks = 0;
        ListNode accessPt = null;
        var inCache = new HashSet<ListNode>();
        var intersec = new ArrayList<ListNode>();
        for (int i = 0; i < cache.length; i++) {
            ListNode cur = cache[i];
            if (cur != null) {
                inCache.add(cur);
                accessPt = cur;
            }
        }
        ListNode current = accessPt;
        while (current != null) {
            if (inCache.contains(current)) {
                intersec.add(current);
            }
            current = current.next;
        }
        current = accessPt.prev;
        while (current != null) {
            if (inCache.contains(current)) {
                intersec.add(current);
            }
            current = current.prev;
        }
        for (int i = 0; i < intersec.size(); i++) {
            ListNode cur = intersec.get(i);
            if (!inCache.contains(cur.next)) {
                blocks++;
            }
        }
        return blocks;
    }
}
