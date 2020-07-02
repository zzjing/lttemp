
public class RandomListCloning {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        Map<RandomListNode, RandomListNode> nodeToCopy = new HashMap<>();
        RandomListNode current = head;
        // make deep copies
        while (current != null) {
            nodeToCopy.put(current, new RandomListNode(current.label));
            current = current.next;
        }
        // reconstruct references
        for (Map.Entry<RandomListNode, RandomListNode> node : nodeToCopy.entrySet()) {
            RandomListNode randPt = node.getKey().random;
            RandomListNode nextPt = node.getKey().next;
            RandomListNode copy = node.getValue();
            copy.random = nodeToCopy.get(randPt);
            copy.next = nodeToCopy.get(nextPt);
        }
        return nodeToCopy.get(head);
    }
}
