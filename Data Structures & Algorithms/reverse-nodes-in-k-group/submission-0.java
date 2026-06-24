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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head;
        int cnt = 0;
        while(a!=null && cnt<k){
            cnt++;
            a = a.next;
        }
        if(cnt == k){
            ListNode prev = null, next = null, curr = head;
            int cn =0;
            while(cn<k){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                cn++;
            }
            head.next = reverseKGroup(next, k);
            return prev;
        }
        return head;
    }
}