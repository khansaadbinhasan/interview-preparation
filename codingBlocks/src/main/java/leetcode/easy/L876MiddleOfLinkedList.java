package leetcode.easy;

//[1,2,3,4,5]
//[1,2,3,4,5,6]
//[1]
//[1,2]
public class L876MiddleOfLinkedList {

     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode middleNode(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        if( fast.next == null ) return slow;

        while( fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }


}
