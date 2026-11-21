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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
         if(head == null || head.next == null || head.next.next == null)
       {
           return new int[]{-1, -1};
       }
       List<Integer> critcalPoints = new ArrayList<>();
       ListNode prev = head;
       ListNode curr = head.next;
       int position = 1;
       while(curr.next != null)
       {
         if((curr.val> prev.val && curr.val > curr.next.val) || 
         (curr.val < prev.val && curr.val < curr.next.val)){
            critcalPoints.add(position);
         }
         prev = curr;
         curr= curr.next;
         position++;

       }
       if(critcalPoints.size() < 2)
       {
        return new int[]{-1, -1};
       }
       int minDistance = Integer.MAX_VALUE;
       int maxDistance = critcalPoints.get(critcalPoints.size() -1) -    
       critcalPoints.get(0);
       for(int i =1 ; i< critcalPoints.size();i++){
        minDistance = Math.min(minDistance, critcalPoints.get(i) -   
        critcalPoints.get(i-1));
       }
       return new int[]{minDistance, maxDistance};

    }
}