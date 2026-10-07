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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;
        ListNode newHead = reverse(mid);
        ListNode temp = head;

        while(newHead != null){
            if(temp.val != newHead.val){
                return false;
            }
            temp = temp.next;
            newHead = newHead.next;
        }

        return true;

    }

    public ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = node;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}