// Given a LinkedList, every node contains a array. Every element of the array is char

class Node {
    char[] block = new char[5]; // fixed size
    int length; // how many chars are actually present in that block
    Node next;
    public Node() { // can pass in fixed size
    }
}

class LinkedList {
    Node head;
    int totalLength; // how many chars overall are actually present across all blocks
    public LinkedList(Node head, int totalLength) {
        this.head = head;
        this.totalLength = totalLength; // totalLength may not be given
        // to compute total length if necessary
        int count = 0;
        Node current = head;
        while (current != null) {
            count += current.length;
            current = current.next;
        }
        totalLength = count;
    }

    public char get(int index) { // 1. get(int index) find the char at the index
        if (index < 0 || index >= totalLength || totalLength == 0) {
            return '';
        }
        Node current = head;
        while (current != null && index >= 0) {
            if (index >= current.length) {
                index -= current.length;
            } else {
                return current.block[index];
            }
            current = current.next;
        }
        return '';
    }
    // 2. insert(char ch, int index) insert the char to the index
    // 1. normal insertion
    // 2. node is full, create and insert a new node in middle
    // 3. node is full, create a new node at the end - aka append
    public void insert(char ch, int index) {
        if (index > totalLength) { // this is not insertion
            return;
        }
        Node current = head;
        while (current != null && index >= 0) {
            if (index >= current.length) {
                index -= current.length;
            } else { // before inserting entry in the middle of a block, which is full
                if (current.length == 5) {
                    Node newNextNode = new Node(); // new node to host overflowed
                    newNextNode.block[0] = current.block[4];
                    newNextNode.length = 1;
                    newNextNode.next = current.next; // insert a new node
                    current.next = newNextNode;
                    current.length--;
                }
                current.length++;
                // insert and shift
                for (int i = current.length - 1; i > index; i--) {
                    current.block[i] = current.block[i - 1]; // shift right
                }
                current.block[i] = ch; // insert
                break;
            }
            current = current.next;
        }
        if (current == null) { // needs a new node at the end of the list
            Node endNode = new Node();
            endNode.block[0] = ch;
            endNode.length = 1;
            Node current2 = new Node();
            current2.next = head;
            // moves to the end of a list
            while (current2.next != null) {
                current2 = current2.next;
            }
            current2.next = endNode;
        }
        totalLength++; // after insertion
    }

    // followup
    public void delete(int index) {
        if (index < 0 || index >= totalLength) {
            return;
        }
        Node prev = new Node();
        prev.next = head;
        Node current = head;
        while (current != null && index >= 0) {
            if (index >= current.length) {
                index -= current.length;
            } else {
                if (current.length == 1) { // delete the node along with only entry to remove
                    prev.next = current.next;
                } else {
                    for (int i = index; i < current.length - 1; i++) { // due to [i] = [i + 1]
                        current.block[i] = current.block[i + 1]; // shift left
                    }
                    current.length--;
                }
            }
            prev = prev.next;
            current = current.next;
        }
        totalLength--;
    }
}
