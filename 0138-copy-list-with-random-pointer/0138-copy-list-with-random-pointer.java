/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public void copyInBetween(Node head){
        Node temp = head;

        while(temp != null){
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;

        }
    }

    public void connectRandom(Node head){
        Node temp = head;

        while(temp != null){
            Node copyNode = temp.next;
            if(temp.random != null){
                copyNode.random = temp.random.next;
            }
            else{
                copyNode.random = null;
            }

            temp = temp.next.next;
        }
    }

    public Node connect(Node head){
        Node dummy = new Node(-1);
        Node result = dummy;

        Node temp = head;

        while(temp != null){
            result.next = temp.next;
            result = result.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }

        return dummy.next;
    }
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }

        copyInBetween(head);
        connectRandom(head);
        return connect(head);
    }
}