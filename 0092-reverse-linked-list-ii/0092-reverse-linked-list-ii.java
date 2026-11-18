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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = head;
        ListNode leftPrev = dummy;

        for(int i =0; i< left -1;i++){
            leftPrev = leftPrev.next;
            curr = curr.next;
        }

        ListNode subHead = curr;
        ListNode prev = null;

        for(int i =0; i<= right - left;i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        subHead.next = curr;
        leftPrev.next = prev;

        return dummy.next;
    }
}