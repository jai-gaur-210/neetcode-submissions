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
        List<Integer> arr = new ArrayList<>();
        int k = 0;
        for(ListNode n : lists){
            while(n!=null){
                arr.add(n.val);
                n = n.next;
            }
        }
        Collections.sort(arr);
        ListNode temp = new ListNode(0);
        ListNode ans = temp;
        for(int i : arr){
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return ans.next;
    }
}
