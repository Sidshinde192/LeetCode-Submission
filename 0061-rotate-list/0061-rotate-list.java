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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        int count = 1;

        ListNode tail = head;

        while(tail.next != null){
            tail = tail.next;
            count++;
        }

        k %= count;

        if(k == 0){
            return head;
        }

        tail.next = head;
        ListNode newNode = kNode(head, count - k);
        head = newNode.next;
        newNode.next = null;

        return head;
        
    }

    public ListNode kNode(ListNode temp, int k){
        k -=1;

        while(temp != null && k > 0){
            k--;
            temp = temp.next;
        }

        return temp;
    }
}