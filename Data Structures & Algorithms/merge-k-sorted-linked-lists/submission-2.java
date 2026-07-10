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
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode l : lists){
            if(l!=null){
                q.offer(l);
            }
        }
        ListNode temp = new ListNode(0);
        ListNode ans = temp;
        while(!q.isEmpty()){
            temp.next = q.poll();
            temp = temp.next;

            if(temp.next!=null){
                q.offer(temp.next);
            }
        }
        return ans.next;
    }
}
