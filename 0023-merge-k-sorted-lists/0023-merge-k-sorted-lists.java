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
        if(lists == null || lists.length == 0){
            return null;
        }
        int n = lists.length;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for(ListNode node : lists){
            if(node != null){
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            temp.next = curr;
            temp = temp.next;
            if(curr.next != null){
                pq.add(curr.next);
            }
        }

        return dummy.next;

        
    }
}