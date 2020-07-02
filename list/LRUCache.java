
public class LRUCache {
    private class DoublyNode {
        DoublyNode prev;
        DoublyNode next;
        int key;
        int value;
        public DoublyNode (int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    private int capacity;
    private Map<Integer, DoublyNode> lookup;
    private DoublyNode head;
    private DoublyNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        lookup = new HashMap<>();
        head = new DoublyNode(-1, -1);
        tail = new DoublyNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!lookup.containsKey(key)) {
            return -1;
        }
        DoublyNode mostRecent = lookup.get(key);
        mostRecent.next.prev = mostRecent.prev;
        mostRecent.prev.next = mostRecent.next;
        moveToHead(mostRecent);
        return mostRecent.value;
    }
    
    public void put(int key, int value) {
        if (get(key) != -1) {
            DoublyNode mostRecent = lookup.get(key);
            mostRecent.value = value;
            mostRecent.next.prev = mostRecent.prev;
            mostRecent.prev.next = mostRecent.next;
            moveToHead(mostRecent);
            return;
        }
        if (lookup.size() == capacity) {
            lookup.remove(tail.prev.key);
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
        }
        DoublyNode insertion = new DoublyNode(key, value);
        lookup.put(key, insertion);
        moveToHead(insertion);
    }

    private void moveToHead(DoublyNode mostRecent) {
        head.next.prev = mostRecent;
        mostRecent.next = head.next;
        mostRecent.prev = head;
        head.next = mostRecent;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
