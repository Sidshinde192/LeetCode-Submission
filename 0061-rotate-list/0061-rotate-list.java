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

        int count =1;
        ListNode tail = head;

        while(tail.next != null){
            tail = tail.next;
            count++;
        }

        if(k == 0){
            return head;
        }

        k %= count;

        tail.next = head;
        ListNode newNode = knode(head, count - k);
        head = newNode.next;
        newNode.next = null;
        return head;
    }

    public ListNode knode(ListNode temp, int k){
        k -= 1;

        while(temp != null && k > 0){
            temp = temp.next;
            k--;
        }

        return temp;
    }
}