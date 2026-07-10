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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            cnt++;
        }
        cnt = cnt-n;
        ListNode prev = new ListNode(0);
        ListNode ans = prev;
        prev.next = head;
        while(cnt>0){
            prev = prev.next;
            cnt--;
        }
        prev.next = prev.next.next;
        
        return ans.next;
    }
}
