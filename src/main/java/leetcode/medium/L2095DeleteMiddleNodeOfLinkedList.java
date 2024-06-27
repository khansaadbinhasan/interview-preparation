package leetcode.medium;

public class L2095DeleteMiddleNodeOfLinkedList {

     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteMiddle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        //find middle then delete
        while( fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }

        if( slow == head ) {
            return head.next;
        }

        ListNode p = head;

        while( p != null && p.next != slow  ){
            p = p.next;
        }

        p.next = slow.next;

        return head;
    }

}
