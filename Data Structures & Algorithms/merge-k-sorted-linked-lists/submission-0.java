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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<lists.length; i++){
            ListNode curr = lists[i];
            while(curr!=null){
                queue.add(curr.val);
                curr = curr.next;
            }
        }
        ListNode a = new ListNode();
        ListNode b = a;
        while(queue.size() > 0){
            ListNode temp = new ListNode(queue.remove());
            a.next = temp;
            a = a.next;
        }
        return b.next;
    }
}