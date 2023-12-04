package leetcode.easy;

//[1,2,2,1]
//[1,2]
//[1]
//[0]
//[1,2,3,4,5,6]
//[1,2,3,4,5,6,7,6,5,4,3,2,1]
//[1,2,3,4,5,6,7,7,6,5,4,3,2,1]
//[1]
//[1,1,1,1,4,5,6,7,1,1,1,1]

public class L237DeleteNodeInLinkedList {

     class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }

    public void deleteNode(ListNode node) {
        if( node == null ) return;

        node.val = node.next.val;
        node.next = node.next.next;
    }

}
