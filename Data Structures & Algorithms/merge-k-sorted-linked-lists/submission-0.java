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

        // Step 1: Collect all values
        List<Integer> values = new ArrayList<>();

        for (ListNode node : lists) {

            while (node != null) {
                values.add(node.val);
                node = node.next;
            }
        }

        // Step 2: Sort all values
        Collections.sort(values);

        // Step 3: Create the resulting linked list
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        for (int value : values) {

            tail.next = new ListNode(value);
            tail = tail.next;
        }

        return dummy.next;
    }
}
