class ListPartition {
public:
    ListNode * partition(ListNode *head, int x) {
        ListNode dummy1(0);
        ListNode dummy2(0);
        ListNode *p1 = &dummy1;
        ListNode *p2 = &dummy2;
        while (head) {
            if (head->val < x) {
                p1->next = head;
                p1 = head;
            } else {
                p2->next = head;
                p2 = head;
            }
            head = head->next;
        }
        p2->next = NULL;
        p1->next = dummy2.next;
        return dummy1.next;
    }
};
