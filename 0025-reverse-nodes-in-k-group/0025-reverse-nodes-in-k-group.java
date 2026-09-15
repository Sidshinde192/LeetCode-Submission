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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;

        while(temp != null){
            ListNode kNode = findKnode(temp, k);

            if(kNode == null){
                if(prev != null){
                    prev.next = temp;
                   
                }
                break;
            }

            ListNode nextNode = kNode.next;
            kNode.next = null;
            reverse(temp);
            if(temp == head){
                head = kNode;
            }
            else{
                prev.next = kNode;
            }

            prev = temp;
            temp = nextNode;
        }

        return head;
    }


    public ListNode findKnode(ListNode temp , int k){
        k -=1;

        while(temp != null && k > 0){
            temp = temp.next;
            k--;
        }

        return temp;
    }

    public ListNode reverse(ListNode temp){
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = temp;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}