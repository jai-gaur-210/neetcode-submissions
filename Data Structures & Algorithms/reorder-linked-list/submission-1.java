/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode end = slow.next;
        slow.next = null;
        ListNode prev = null;
        while(end!=null){
            ListNode temp = end.next;
            end.next = prev;
            prev = end;
            end = temp;
        }
        ListNode start = head;
        while(prev!=null){
            ListNode t1 = start.next;
            ListNode t2 = prev.next;
            start.next = prev;
            prev.next = t1;
            start = t1;
            prev = t2;
        }
    }
}
