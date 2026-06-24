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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        ListNode a = null;
        ListNode b = null;
        if(list1.val <= list2.val){
            a = list1;
            b = a;
            list1= list1.next;
        }
        else{
            a = list2;
            b = a;
            list2=list2.next;
        }
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                a.next = list1;
                a = a.next;
                list1 = list1.next;
            }
            else{
                a.next = list2;
                a = a.next;
                list2 = list2.next;
            }
        }
        while(list1 != null){
            a.next = list1;
            a = a.next;
            list1 = list1.next;
        }
        while(list2 != null){
            a.next = list2;
            a = a.next;
            list2 = list2.next;
        }
        return b;
    }
}