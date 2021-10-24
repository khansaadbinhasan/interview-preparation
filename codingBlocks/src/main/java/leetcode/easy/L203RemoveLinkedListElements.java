package leetcode.easy;

//[1,2,6,3,4,5,6]
//6
//[]
//1
//[7,7,7,7]
//7
//[1]
//1
//[1,2,3]
//3
//[1,2,3]
//1
//[1,2,2,1]
//2
public class L203RemoveLinkedListElements {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode removeElements(ListNode head, int val) {

        if( head == null ) return head;

        while( head != null && head.val == val ) head = head.next;

        if( head == null ) return head;

        ListNode nodePrev = null;
        ListNode node = head;

        while( node != null ){

            nodePrev = node;
            node = node.next;

            while( node != null && node.val == val ) {
                node = node.next;
            }

            nodePrev.next = node;

        }

        return head;

    }


}
