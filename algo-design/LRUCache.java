
public class LRUCache {
    private class Node {
        Node prev;
        Node next;
        int key;
        int value;
        public Node (int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private Map<Integer, Node> search = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (!search.containsKey(key)) {
            return -1;
        }
        Node current = search.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        moveToTail(current);
        return search.get(key).value;
    }

    public void put(int key, int value) {
        // update the value and update its location
        if (get(key) != -1) {
            Node current = search.get(key);
            current.value = value;
            current.prev.next = current.next;
            current.next.prev = current.prev;
            moveToTail(current);
            return;
        }
        if (search.size() == capacity) {
            search.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node insert = new Node(key, value);
        search.put(key, insert);
        moveToTail(insert);
    }

    private void moveToTail(Node current) {
        current.next = tail;
        tail.prev.next = current;
        current.prev = tail.prev;
        tail.prev = current;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
