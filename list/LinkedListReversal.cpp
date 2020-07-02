/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class LinkedListReversal {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode* reversedHead = NULL;
        ListNode* current = head;
        while (current != NULL) {
            ListNode* next = current->next;
            current->next = reversedHead;
            reversedHead = current;
            current = next;
        }
        return reversedHead;
    }

    ListNode* reverseList(ListNode* head) {
        if (head == NULL || head->next == NULL) {
            return head;
        }
        ListNode* reversed = reverseList(head->next);
        head->next->next = head;
        head->next = NULL;
        return reversed;
    }
};
