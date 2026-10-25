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
        List<Integer> arr = new ArrayList<>();

        for(int i =0; i< n;i++){
            ListNode temp = lists[i];
            while(temp != null){
                arr.add(temp.val);
                temp = temp.next;
            }
        }

        Collections.sort(arr);
        ListNode result = new ListNode(-1);
        ListNode dummy = result;

        for(int i =0; i< arr.size();i++){
            dummy.next = new ListNode(arr.get(i));
            dummy = dummy.next;
        }

        return result.next;
    }
}