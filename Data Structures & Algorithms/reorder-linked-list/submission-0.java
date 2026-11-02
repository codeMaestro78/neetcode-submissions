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
        
        if(head == null || head.next == null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head;


        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast =  fast.next.next;
        }

        // split the List
        ListNode second = slow.next;
        slow.next =null;


        // reverse the second half
        ListNode prev = null;
        ListNode curr = second;

        while(curr!=null){
            ListNode nextTemp = curr.next;

            curr.next = prev;

            prev =curr;
            curr= nextTemp;
        }

        second =prev;

        // merge both halves
        ListNode first = head;

        while(second!=null){
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }
}
